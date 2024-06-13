package basic.number;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1929
public class 소수구하기_037 {

    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N+1];
        for(int i=2; i<=N; i++) {
            A[i] = i;
        }

        // 제곱근까지 수행
        for(int i=2; i<= Math.sqrt(N); i++) {
            // 이미 소수가 아니라고 판된된 수면 넘어감
            if(A[i] == 0) {
                continue;
            }

            // 배수 지우기
            for(int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }
        }

        for(int i=M; i<=N; i++) {
            if(A[i] !=0 ) {
                System.out.println(A[i]);
            }
        }
    }

}
