package actual.graph;

// https://www.acmicpc.net/problem/1707

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 이분그래프_048 {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        // 입력값 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스
        for(int t=0; t < N; t++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]); // 노드 수
            int e = Integer.parseInt(s[1]); // 에지 수

            A = new ArrayList[v+1];
            visited= new boolean[v+1];
            check = new int[v+1];
            isEven = true;
            for(int i=1; i<=v; i++) {
                A[i] = new ArrayList<>();
            }

            // 인접 리스트로 그래프 저장하기
            for(int i=0; i<e; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 각 노드에서 DFS 실행
            // 주어진 그래프가 하나로 연결되어 있다는 보장이 없으므로 모든 노드에서 수행
            for(int i=1; i<=v; i++) {
                if(isEven) {
                    DFS(i);
                } else {
                    break;
                }
            }
            check[1] = 0;
            if(isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            System.out.println(Arrays.toString(A));
        }
    }

    public static void DFS(int node) {
        visited[node] = true;
        for(int i : A[node]) {
            // 방문하지 않은 노드
            if(!visited[i]) {
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            // 이미 방문한 노드가 현재 노드와 같은 집합이면 이분 그래프 아님
            else if(check[i] == check[node]){
                isEven = false;
            }
        }
    }
}
