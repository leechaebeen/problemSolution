package basic.number;

// https://www.acmicpc.net/problem/1456

import java.util.Scanner;

public class 거의소수구하기_038 {

    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long[] A = new long[10000001];
        for(int i=2; i<A.length; i++) {
            A[i] = i;
        }

        // 소수 구하기 - 제곱근까지만 수행하기
        for(int i=2; i<Math.sqrt(A.length); i++) {
            if(A[i] == 0) {
                continue;
            }
            // 배수 지우기
            for(int j = i + i; j < A.length; j = j + i) {
                A[j] = 0;
            }
        }

        int count = 0;
        for(int i = 2; i < 10000001; i++) {
            // 소수일 때
            if(A[i] != 0) {
                long temp = A[i]; // 현재 소수

                // 현재 소수의 제곱근이 max 보다 같거나 작을 때 -> Math.sqrt(A[i]) <= max
                // 곱셈이 long 범위를 넘어갈 수 있어 이항 정리로 처리
                while((double) A[i] <= max /(double) temp) {
                    if((double) A[i] >= min /(double) temp) {
                        count++;
                    }
                    temp = temp * A[i]; // 소수의 N 제곱
                }
            }
        }
        System.out.println(count);
    }
}
