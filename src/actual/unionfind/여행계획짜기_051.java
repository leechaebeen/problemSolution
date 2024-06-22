package actual.unionfind;

// https://www.acmicpc.net/problem/1976

import java.lang.reflect.Field;
import java.util.Scanner;

public class 여행계획짜기_051 {

    private static int[] parent;

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 도시 개수
        int M = sc.nextInt(); // 여행 경로 수

        // 도시 연결 데이터 저장
        int[][] dosi = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                dosi[i][j] = sc.nextInt();
            }
        }

        // 여행 경로 저장
        int[] route = new int[M];
        for(int i=0; i<M; i++) {
            route[i] = sc.nextInt() - 1; // 0부터 시작인 배열이므로 도시 번호를 맞춤
        }

        // 대표 노드 초기화
        parent = new int[N];
        for(int i=0; i<N; i++) {
            parent[i] = i;
        }

        // union
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dosi[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 여행할 도시들이 같은 집합인지 확인(=1개의 대표 도시로 연결되어 있는지)
        int index = find(route[0]);
        for(int i=1; i<route.length; i++) {
            if(index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if(parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}
