package actual.unionfind;

// https://www.acmicpc.net/problem/1717

import java.util.Scanner;

public class 집합표현하기_050 {
    public static int[] parent;

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 개수
        int M = sc.nextInt(); // 질의 수
        parent = new int[N+1];
        // 대표 노드를 자신으로 초기화
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        // 질의 처리
        for (int i=0; i<M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            // union
            if(question == 0) {
                union(a,b);
            }
            // find
            else {
                if(checkSameGroup(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        // 대표 노드 찾기
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    // 대표 노드 찾기
    private static int find(int a) {
        if(a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]); // 재귀함수의 형태로 구현 -> 경로 압축
        }
    }

    // 두 노드가 같은 집합인지 확인
    private static boolean checkSameGroup(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) {
            return true;
        }
        return false;
    }
}
