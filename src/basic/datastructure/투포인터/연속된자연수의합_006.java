package basic.datastructure.투포인터;

import java.util.Scanner;

public class 연속된자연수의합_006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 1;
        int startIndex = 1;
        int endIndex = 1;
        int count = 1;

        while(endIndex != N) {
            if(sum == N) {
                // 이동하고 더해주기
                endIndex++;
                sum += endIndex;
                count++;
            } else if (sum > N) {
                // 기존 값을 빼주고 이동하기
                sum -= startIndex;
                startIndex++;
            } else if (sum < N) {
                // 이동하고 더해주기
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.println(count);
    }
}
