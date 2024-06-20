package actual.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1325
public class 효율적으로해킹하기_047 {
    static int N, M;
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        // 입력값 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        answer = new int[N + 1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
        }

        // 모든 노드로 BFS 실행
        for(int i=1; i<=N; i++) {
            visited = new boolean[N + 1]; // BFS 전 방문 노드 초기화
            BFS(i);
        }

        // 방문된 수 == 신뢰하는 노드의 수
        // 자신을 신뢰하는 노드가 가장 많은 노드 찾기
        int maxVal = 0;
        for(int i=1; i<=N; i++) {
            maxVal = Math.max(maxVal, answer[i]);
        }

        // 자신을 신뢰하는 노드가 가장 많은 노드 출력
        for(int i=1; i<=N; i++) {
            if(maxVal == answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            for(int i : A[nowNode]) {
                if(!visited[i]) {
                    visited[i] = true;
                    answer[i]++; // 방문한 노드의 신뢰값 증가시키기
                    queue.add(i);
                }
            }
        }
    }

}
