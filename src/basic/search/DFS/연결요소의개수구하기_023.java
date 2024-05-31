package basic.search.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11724
public class 연결요소의개수구하기_023 {

    static ArrayList<Integer>[] A; // 인접 리스트 배열
    static boolean[] visited;      // 방문 기록 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n + 1]; // index + 1
        visited = new boolean[n + 1];

        // 인접리스트 초기화
        for(int i = 1; i < n+1; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양방향 연결
            A[s].add(e);
            A[e].add(s);
        }

        // 모든 노드를 방문할 때까지 반복하기
        int result = 0;
        for(int i = 1; i < n + 1; i++) {
            if(!visited[i]) {
                result++;
                DFS(i); // i = 노드 번호
            }
        }

        System.out.println(result);
    }

    static void DFS(int v) {
        // 이미 방문한 노드는 방문하지 않음
        if(visited[v]) {
            return;
        }
        visited[v] = true;

        // 연결된 노드 중 방문하지 않은 노드 탐색
        for(int i : A[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
