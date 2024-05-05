package basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 구간합구하기2_004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N+1][N+1]; // 원본 배열
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구간합 배열
        // 구간합 구하기 : 원본 배열 (0,0) 부터 (i,j)까지의 합 == 구간합 배열 (i, j)
        int[][] D = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
                // (0,0) 부터 내 위의 칸까지 합+ (0,0)부터 내 앞의 칸까지 합 - 두 번 더한 칸 + 원본 배열 현재 칸의 값
            }
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 구간합 배열로 질의에 답변하기
            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            // 전체 칸 - 행 제거 - 열 제거 + 두 번 제거된 영역
            System.out.println(result);
        }
    }
}