package basic.greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1744
public class 수를묶어서최댓값만들기_034 {

    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음의 수 저장하기

        // 양수는 내림차순 정렬하기
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        // 4개의 그룹으로 분리해 저장하기
        for(int i=0; i<N; i++) {
            int data = sc.nextInt();
            if(data > 1) {
                plusPq.add(data);
            } else if (data == 1) {
                one++;
            } else if( data == 0) {
                zero++;
            } else if (data < 0) {
                minusPq.add(data);
            }
        }

        int sum =0;

        // 양수 처리하기 - 가장 큰 수끼리 곱하기
        while(plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += first * second;
        }

        // 홀수여서 남아있다면
        if(!plusPq.isEmpty()) {
            sum += plusPq.remove();
        }

        // 음수 처리하기 - 가장 작은 수끼리 곱해서 양수로 만들기
        while(minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += first * second;
        }

        if(!minusPq.isEmpty()) {
            // 0 이 없으면 음수를 더해줌.
            if(zero == 0) {
                sum += minusPq.remove();
            }
        }
        // 1 처리하기
        sum += one;
        System.out.println(sum);
    }
}
