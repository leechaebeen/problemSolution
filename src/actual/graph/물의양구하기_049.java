package actual.graph;

// https://www.acmicpc.net/problem/2251

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 물의양구하기_049  {
    // 6가지 이동 케이스를 표현하기 위한 배열
    // A-> B, A->C, B->A, B->C, C->A, C->B
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,2,0,2,0,1};
    static boolean[][] visited; // A,B 의 무게만 있으면 C 의 무게가 고정되므로 2개만 체크
    static boolean[] answer;
    static int[] now; // 물통 용량

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        now = new int[3]; // A,B,C 각 물통의 용량을 저장하는 배열
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        for(int i = 0; i < answer.length; i++) {
            if(answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        // 최초 출발 노드 세팅
        queue.add(new AB(0,0));
        visited[0][0] = true;
        answer[now[2]] = true; // C 의 양

        while(!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B; // C 는 전체 물의 양에서 A,B 를 뺀 값 -> ? now[2] 가 왜 전체 물의 양이지? -> now(물통 용량)는 변하지 않음

            // 6가지의 경우
            for(int k=0; k<6; k++) {
                int[] next = {A, B, C}; // 물의 양
                next[receiver[k]] += next[sender[k]]; // 물의 양
                next[sender[k]] = 0;
                // 물이 넘칠 때
                if(next[receiver[k]] > now[receiver[k]]) {
                    // 초과하는 만큼 다시 이전 물통에 넣어줌
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    // 대상 물통은 최대로 채워줌
                    next[receiver[k]] = now[receiver[k]];
                }

                // A 와 B 의 물의 양을 이용해 방문 배열 체크
                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    // A의 물의 양이 0 일 때 정답 변수에 저장
                    if(next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

// AB 클래스 -> A 와 B 의 값만 지니고 있으면 C는 유추할 수 있으므로 두 변수만 사용하기
class AB {
    int A;
    int B;

    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}
