package basic.datastructure.스택과큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2164
public class 카드게임_013 {

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();

        // queue 초기화
        for(int i =1; i<=N; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            queue.poll(); // 첫번째 요소 제거
            int newLastnum = queue.poll(); // 두번째 요소 마지막에 넣기
            queue.add(newLastnum);
        }

        System.out.println(queue.poll());

    }
}
