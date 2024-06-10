package basic.greedy;

// https://www.acmicpc.net/problem/1715

import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기_033 {

    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음의 수
        PriorityQueue<Integer>  pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            int data = sc.nextInt(); // 카드 수
            pq.add(data);
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;

        while(pq.size() != 1) {
            data1 = pq.remove(); // 현재 큐 중 가장 작은 수
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1+data2);
        }

        System.out.println(sum);

    }
}
