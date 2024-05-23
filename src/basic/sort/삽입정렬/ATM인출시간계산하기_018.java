package basic.sort.삽입정렬;

// https://www.acmicpc.net/problem/11399

import java.util.Arrays;
import java.util.Scanner;

// 인출 시간이 적게 걸리는 사람 순으로 먼저 인출하도록 한다.(그리디 방식)
// 앞 사람의 인출 시간이 뒤의 모든 사람에게 영향을 주므로
public class ATM인출시간계산하기_018 {

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N]; // 합배열

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        // 삽입 정렬
        for(int i=1; i<N; i++) {
            int target = A[i];
            int j = i - 1;

            // 타겟이 이전 원소보다 작으면 반복
            while(j >= 0 && target < A[j]) {
                A[j + 1] = A[j];// 이전 원소를 한 칸씩 뒤로 미룬다.
                j--; // 최소 -1 이 된다.
            }

            /*
             * 위 반복문에서 탈출 하는 경우 타겟이 앞의 원소보다 (같거나)크다는 의미이므로
             * 타겟 원소는 j번째 원소 뒤에 와야 한다.
             * 그러므로 타겟은 j + 1 에 위치하게 된다.
             */
            A[j + 1] = target;
        }

        // 합 배열
        S[0] = A[0];
        for(int i=1; i<A.length; i++) {
            S[i] = S[i-1] + A[i];
        }

        // 합 구하기
        int sum = 0;
        for(int i=0; i<S.length; i++) {
            sum += S[i];
        }

        System.out.println(sum);
        
    }
}
