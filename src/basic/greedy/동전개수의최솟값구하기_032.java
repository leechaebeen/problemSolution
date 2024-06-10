package basic.greedy;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11047
public class 동전개수의최솟값구하기_032 {

    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 동전의 수
        int price = sc.nextInt(); // 목표 금액
        int[] coinArr = new int[N];

        for(int i=0; i < N; i++) {
            coinArr[i] = sc.nextInt();
        }

        int result = 0;
        for(int i = N-1; i >= 0; i--) {
            // 현재 동전의 값이 구하려는 값보다 작으면
            if(coinArr[i] <= price) {
                result += price/coinArr[i];
                // 현재 동전을 사용하고 남은 가격 업데이트
                price %= coinArr[i];
            }
        }

        System.out.println(result);
    }
}


