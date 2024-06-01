package basic.search.BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1167
public class 트리의지름구하기_028 {

    static ArrayList<Node>[] A;
    static int[] distanceArr;
    static boolean[] visitedArr;

    public static void main(String[] args) throws IOException {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        A = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            int node = sc.nextInt();
            while(true)  {
                int n = sc.nextInt();
                if(n == -1) {
                    break;
                }
                int d = sc.nextInt();
                A[node].add(new Node(n, d));

            }
        }

        distanceArr = new int[N+1];
        visitedArr = new boolean[N+1];
        BFS(1);

        // 임의의 노드에서 가장 긴 경로로 연결되어 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나이다.
        // 그러니 그 노드를 찾아서 BFS 를 수행해 각 노드 별 경로 거리를 계산 했을 때 가장 긴 거리가 지름이다.
        int maxNode = 1;
        // distance 배열에서 가장 큰 값으로 다시 시작 설정, 1은 방문했으니까 2부터
        for (int i=2; i <=N; i++) {
            if(distanceArr[maxNode] < distanceArr[i]) {
                maxNode = i;
            }
        }

        // 새로운 시작점으로 다시 시작
        distanceArr = new int[N+1];
        visitedArr = new boolean[N+1];
        BFS(maxNode);

        Arrays.sort(distanceArr);
        System.out.println(distanceArr[N]);
    }

    public static void BFS(int nodeNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nodeNum);
        visitedArr[nodeNum] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            for(Node node : A[nowNode]) {
                // 방문한 노드면 넘어가기
                if(visitedArr[node.node]) {
                    continue;
                }
                visitedArr[node.node] = true;
                queue.offer(node.node);
                distanceArr[node.node] = distanceArr[nowNode] + node.getDistance();
            }
        }
    }



    public static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int getDistance() {
            return this.distance;
        }
    }
}
