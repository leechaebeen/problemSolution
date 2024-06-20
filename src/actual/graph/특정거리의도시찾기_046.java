package actual.graph;

import java.util.*;

// https://www.acmicpc.net/problem/18352
public class 특정거리의도시찾기_046 {

    static int[] visited;
    static ArrayList<Integer>[] A;
    static int N, M, K, X; // 노드 개수, 에지 개수, 목표 거리, 시작점
    static List<Integer> answer;

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        A = new ArrayList[N+1];
        answer = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }

        // BFS 전 방문 배열 초기화
        visited = new int[N+1];
        for(int i=0; i<=N; i++) {
            visited[i] = -1;
        }

        BFS(X);

        for(int i=0; i<=N; i++) {
            if(visited[i] == K) {
                answer.add(i);
            }
        }
        if(answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for(int i : answer) {
                System.out.println(i);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            for(int i : A[nowNode]) {
                if(visited[i] == -1) {
                    visited[i] = visited[nowNode]+1;
                    queue.add(i);
                }
            }
        }
    }
}
