package basic.search.이진탐색;

import java.util.Scanner;

public class 블루레이만들기_030 {
    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for(int i=0; i < N; i++) {
            A[i] = sc.nextInt();
            // 레슨 최댓값을 시작 인덱스로 지정하기
            // (레슨은 중간에 끊겨서 저장되지 않으므로 블루레이 저장 공간의 최솟값이 된다.)
            if(start < A[i]) {
                start = A[i];
            }
            // 모든 레슨의 총합을 종료 인덱스로 지정하기
            end = end+A[i];
        }

        // 이진 탐색
        while(start <= end) {
            int middle = (start + end) /2; // 중간 인덱스, 현재 블루레이의 크기
            int sum = 0;    // 레슨 합
            int count = 0;  // 현재 사용한 블루레이 개수

            // middle 값으로 모든 레슨을 저장할 수 있는지 확인
            for(int i=0; i<N; i++) {
                // 현재 블루레이에 저장할 수 없어 새로운 블루레이로 교체한다는 의미
                if(sum + A[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }

            // 탐색 후 sum 이 0 이 아니면 블루레이가 1개 더 필요하므로 더함
            if(sum != 0) {
                count++;
            }
            
            // 중간 인덱스 값으로 모든 레슨 저장 불가능
            if(count > M) {
                start = middle + 1;
            } 
            // 중간 인덱스 값으로 모든 레슨 저장 가능
            else {
                end = middle - 1;
            }
        }
        System.out.println(start);
    }
}
