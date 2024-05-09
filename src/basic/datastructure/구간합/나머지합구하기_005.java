package basic.datastructure.구간합;

import java.util.Scanner;

public class 나머지합구하기_005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 수열의 수
        int M = sc.nextInt();   // 나누어 떨어져야 하는 수
        long[] S = new long[N]; // 합배열
        long[] C = new long[M]; // 같은 나머지 인덱스를 카운트하는 배열

        long answer = 0;
        S[0] = sc.nextInt();

        // 수열 합 배열 만들기
        for(int i = 1; i < N; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }

        // 합 배열의 모든 값에 % 연산 수행하기
        for(int i = 0; i < N; i++) {
            int reminder = (int) (S[i] % M);
            // 0 ~ i 까지의 구간 합 자체가 0 일 때 정답에 더하기
            if(reminder == 0) {
                answer += 1;
            }
            C[reminder]++;
        }

        // 모르겄는딩
        for(int i = 0; i < M; i++) {
            // 나머지가 같은 수 인덱스 중 2개를 뽑는 경우의 수를 더하기
            if(C[i] >1) {
                answer = answer + (C[i] * (C[i] -1) /2);
            }
        }
        System.out.println(answer);
    }
}
