package basic.datastructure.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값찾기_010 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 입력값 초기화
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int L = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기

        // 덱 사용
        Deque<Node> myDeque = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        st = new StringTokenizer(bf.readLine());

        for(int i=0; i< N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            while(!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }

            myDeque.addLast(new Node(now, i));

            // 범위에서 벗어난 노드는 덱에서 제거
            if(myDeque.getFirst().index <= i-L) {
                myDeque.removeFirst();
            }

            result.append(myDeque.getFirst().value).append(" ");
        }
        System.out.println(result);
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
