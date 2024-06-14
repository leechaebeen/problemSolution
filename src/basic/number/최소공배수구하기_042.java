package basic.number;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1934
public class 최소공배수구하기_042 {

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수
        for(int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a * b / gcd(a,b);
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b) {
        // b 가 0 이면 a 가 최대 공약수
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b); // 재귀 함수
    }
}
