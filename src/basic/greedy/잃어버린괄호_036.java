package basic.greedy;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1541
public class 잃어버린괄호_036 {

    static int answer = 0;
    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();

        String[] str = example.split("-");

        for(int i=0; i < str.length; i++) {
            int temp = sum(str[i]);
            // 가장 앞 데이터인 경우 + , 나머지는 -
            if(i==0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);
    }

    // - 기준으로 나뉜 그룹의 더하기 연산 수행 함수
    private static int sum(String str) {
        int sum = 0;
        String[] nums = str.split("[+]");
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
