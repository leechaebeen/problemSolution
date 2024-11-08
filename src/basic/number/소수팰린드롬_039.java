package basic.number;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1747
public class 소수팰린드롬_039 {

    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[10000001];
        for(int i= 2; i< A.length; i++) {
            A[i] = i;
        }

        // N 의 범위까지 소수 구하기
        for(int i=2; i<Math.sqrt(A.length); i++) {
            if(A[i] == 0) {
                continue;
            }

            // 배수 지우기
            for(int j = i+i; j < A.length; j= j+i) {
                A[j] = 0;
            }
        }

        int i = N;
        // N 부터 1씩 증가시키면서 소수와 펠린드롬 수가 맞는지 확인하기
        while(true) {
            if(A[i] != 0) {
                int result = A[i];
                if(isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int target) {
        char[] temp = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;

        while(s < e) {
            if(temp[s] != temp[e]){
                return false;
            }
            s++;
            e--;
        }

        return true;
    }

}
