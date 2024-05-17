package basic.sort.선택정렬;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1427
public class 내림차순으로자릿수정렬하기_017 {

    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int [str.length()];
        for(int i=0; i< A.length; i++) {
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 선택 정렬
        for(int i=0; i < A.length; i++) {
            int max = i; // index
            for(int j=i+1; j<A.length; j++) {
                // 내림차순이므로 최댓값을 찾음
                if(A[j] > A[max]) {
                    max = j;
                }
            }
            // swap
            if(A[i] < A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }
        for(int num : A) {
            System.out.print(num);
        }

    }

}
