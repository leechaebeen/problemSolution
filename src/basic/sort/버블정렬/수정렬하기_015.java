package basic.sort.버블정렬;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2750
public class 수정렬하기_015  {

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 버블 정렬
        for(int i=0; i < N-1; i++) {
            for(int j=0; j<N-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int num : arr) {
            System.out.println(num);
        }
    }
}
