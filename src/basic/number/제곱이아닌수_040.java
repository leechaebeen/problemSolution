package basic.number;

// https://www.acmicpc.net/problem/1016

import java.util.Scanner;

public class 제곱이아닌수_040 {

    public static void main(String[] args) {

        String text = "Java technology is both a programming language and a platform.";
        System.out.println(text.lastIndexOf('a'));
        System.out.println(text.lastIndexOf("a "));
        System.out.println(text.lastIndexOf('a', 20));
        System.out.println(text.lastIndexOf("a ", 20));
        System.out.println(text.lastIndexOf("z"));

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        // 최댓값과 최솟값의 차이만큼 배열 선언하기
        boolean[] check = new boolean[(int)(max-min +1)];

        // 2의 제곱수인 4부터 제곱수가 max 보다 작거나 같은 값까지 반복하기
        // i : 2의 제곱수, 3의 제곱수, 4의 제곱수
        for(long i = 2; i*i <= max; i++) {
            long pow = i * i; // 제곱수

            // 제곱수 별로 시작 인덱스 구하기
            /*
             나머지가 있으면 1 을 더해야 min 보다 큰 제곱수에서 시작됨
             ex ) 최솟값 6 -> 6/4 = 1(startIndex), 나머지 2
             -> 1 * (2^2) < 6 (최솟값보다 작은 제곱수)
             -> (1+1) * (2^2) > 6 (최솟값보다 큰 제곱수)
             */
            long startIndex = min/pow;
            if(min % pow != 0) {
                startIndex++; 
            }

            // j * pow 가 max 보다 작아야 최솟값, 최댓값 사이의 제곱수이다
            // 제곱수를 true 로 변경하기
            for(long j = startIndex; pow * j <= max; j++) {
                check[(int)((j * pow) - min)] = true; // 배열 인덱스 맞추기 위해 -min
            }
        }

        int count = 0;
        for (boolean b : check) {
            if (!b) {
                count++;
            }
        }

        System.out.println(count);

    }
}
