package basic.number;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/21568
public class 유클리드호제법확장_045 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long gcd = gcd(a, b);

        // c 가 최대공약수의 배수가 아니면 종료
        if(c%gcd != 0) {
            System.out.println(-1);
        } else {
            // 나머지가 0이 될 때까지 재귀 함수를 호출하는 유클리드 호제법 함수 호출
            long[] ret = excute(a, b);

            // 결과값에 c/최대공약수의 값을 곱한 후 해당 값 출력하기
            int mok = (int) (c/gcd);
            System.out.println(ret[0] * mok + " " + ret[1] * mok);
        }
    }

    // 유클리드 호제법 함수 구현
    private static long[] excute(int a, int b) {
        long[] ret = new long[2];
        if(b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        long q = a / b;
        long[] v = excute(b, a%b); // 재귀 형태로 유클리드 호제법 수행
        ret[0] = v[1]; // 역순으로 올라오면서 x,y 값을 계산하는 로직
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    private static long gcd(long a, long b) {
        while(b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

}
