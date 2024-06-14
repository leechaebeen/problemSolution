package basic.number;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1850
public class 최대공약수구하기_043 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = sc.nextLong();
        long b = sc.nextLong();
        long result = gcd(a, b);

        while(result > 0) {
            bw.write("1");
            result--;
        }

        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if(b==0) {
            return a;
        }

        return gcd(b,a % b);
    }
}
