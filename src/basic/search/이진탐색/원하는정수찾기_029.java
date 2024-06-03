package basic.search.이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 원하는정수찾기_029 {
    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for(int i=0; i<M; i++) {
            boolean find = false;
            int target = sc.nextInt();

            // 이진탐색 시작
            int start = 0;
            int end = A.length -1;

            while(start <= end) {
                int midi = (start + end) / 2;
                int midv = A[midi];

                if(midv > target) {
                    end = midi -1;
                }
                else if(midv <  target) {
                    start = midi + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if(find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

/*
public class 원하는정수찾기_029 {

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] findArr = new int[M];
        for(int i=0; i<M; i++) {
            findArr[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(A);
        for(int i=0; i<M; i++) {
           isContain(A, findArr[i]);
        }


    }

    public static void isContain(int[] arr ,int target) {
        int pivot = arr.length/2; // 중간값

        // 중간값보다 타겟이 큰 경우 오른쪽 대상
        if(arr[pivot] < target) {
            int[] newArr = Arrays.copyOfRange(arr, pivot, arr.length);
            lastArrNum(target, newArr);
        }
        // 중간값보다 타켓이 작은 경우 왼쪽 대상
        else if(arr[pivot] > target) {
            int[] newArr = Arrays.copyOfRange(arr, 0, pivot);
            lastArrNum(target, newArr);
        }
        // 동일한 경우
        else if(arr[pivot] == target) {
            System.out.println(1);
        }

    }

    private static void lastArrNum(int target, int[] newArr) {
        if(newArr.length == 1) {
            if(newArr[0] == target) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }
        isContain(newArr, target);
    }
}
*/