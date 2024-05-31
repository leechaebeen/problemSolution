package basic.search.DFS;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/13023
public class 친구관계파악하기_025 {

    static boolean[] visited;

    static ArrayList<Integer>[] A; // 인접 노드 저장
    static boolean arrive; // 5depth 까지 돌았는지

    public static void main(String[] args) {
        int N; // 노드 개수
        int M; // 에지 개수
        arrive = false;

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<>();
        }
        // 양방향 연결
        for(int i=0; i<M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        // 재귀 함수 시작 (사람 수만큼 반복)
        for(int i=0; i< N; i++) {
            DFS(i, 1); // depth1 부터 시작
            if(arrive) {
                break;
            }
        }

        // 출력
        if(arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void DFS(int now, int depth) {
        // depth 5 가 되면 재귀 함수 종료
        // 연속으로 5명째 이어진 경우라면 구하고자 하는 관계임
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }

        // 중복 탐색 되지 않도록 탐색 완료 표시를 한다.
        visited[now] = true;
        for(int i : A[now]) {
            if(!visited[i]) {
                DFS(i, depth +1);
            }
        }

        // 다른 곳에서 다시 탐색을 시작할 때, 탐색이 가능하도록 false 로 재지정
        visited[now] = false;
    }
}
