package basic.search.이진탐색;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1300
public class 배열에서k번째수찾기_031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열의 크기 (이차원 배열 N*N)
        int K = sc.nextInt(); // 구하고자 하는 인덱스

        long start = 1, end = K; // 시작 인덱스와 종료 인덱스 지정
        long answer = 0;

        // 이진 탐색 수행하기
        while(start <= end) {
            long middle = (start + end) /2; // 현재 배열의 중앙 인덱스를 최초 중앙값으로 지정
            long cnt = 0;

            // 중앙값보다 작은 수가 몇 개인지 계산하기
            for(int i = 1; i <= N; i++) {
                cnt += Math.min(middle/i, N); // 작은 수를 카운트하는 핵심 로직
            }

            // 중앙값 세팅
            if(cnt < K) {
                start = middle + 1;
            } else {
                answer = middle;
                end = middle - 1;
            }
        }

        System.out.println(answer);
    }
}
