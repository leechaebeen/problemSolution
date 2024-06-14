package basic.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11689
// 잘 모르겠다 ㅎㅎ
public class 오일러피함수구현하기_041 {

    public static void main(String[] args) throws IOException {

        // 입력값 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()); // 소인수 구성 표시 하는 변수
        long result = n; // 서로소의 개수

        // n의 제곱근까지만 진행하기
        for(long p = 2; p <= Math.sqrt(n); p++) {
            // p 가 소인수라면
            if(n % p == 0) {
                result = result - result/p; // 결과값 업데이트 하기

                // n 에서 현재 소인수 내역 제거하기
                // n : 2^7 * 11 이라면 2^7(p) 를 없애고 11만 남김
                while(n % p == 0) {
                    n = n / p;
                }
            }
        }

        // 아직 소인수 구성이 남아있으면 n 이 마지막 소수라는 뜻. (서로소는 최대 공약수가 1인 자연수이므로)
        if(n > 1) {
            // 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스
            result = result - result/n;
        }

        System.out.println(result);
    }
}
