package basic.datastructure.스택과큐;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11286
// 우선순위 큐
public class 절댓값힙구현하기_014 {
    public static void main(String[] args) throws IOException {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            // 절댓값이 같으면 음수 우선 정렬하기
            if(first_abs == second_abs) {
                // return o1 > o2 ? 1 : -1;
                return o1.compareTo(o2) * -1; // 되는지 확인
            } else {
                // 절댓값을 기준으로 정렬하기
                return first_abs - second_abs;
            }
        });

        for(int i=0; i < N; i++) {
            int request = sc.nextInt();
            if(request == 0) {
                if(MyQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(MyQueue.poll());
                }
            } else {
                MyQueue.add(request);
            }
        }
    }
}
