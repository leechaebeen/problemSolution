package basic.search.BFS;

import java.util.*;

// https://www.acmicpc.net/problem/1260
public class DFS와BFS프로그램_026 {

    static ArrayList<Integer>[] A; // 인접 노드 저장
    static boolean[] visited;      //  방문 여부

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드의 수
        int M = sc.nextInt(); // 간선의 수
        int start = sc.nextInt(); // 시작 노드 번호

        A = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            A[i]  = new ArrayList<>();
        }

        for(int i=0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        // 번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for(int i = 1; i <= N; i++) {
            A[i].sort(null);
        }

        // 방문 배열 초기화
        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        // 방문 배열 초기화
        visited = new boolean[N+1];
        BFS(start);
        System.out.println();
    }

    // 재귀
    public static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;

        // 다음 노드 방문
        for(int i : A[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    // 큐
    public static void BFS(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            System.out.print(nowNode+ " ");

            // 다음 노드 방문
            for(int i : A[nowNode]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i); // 얘는 poll 됐을 때 기준이 되어 탐색함
                }
            }
        }
    }

}
