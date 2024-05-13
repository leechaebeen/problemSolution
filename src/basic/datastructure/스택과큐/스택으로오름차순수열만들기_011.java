package basic.datastructure.스택과큐;

import java.util.*;

//  1부터 N까지의 수를 스택에 입력하면서 printNum 을 순서대로 출력할 수 있는지 확인하는 문제
public class 스택으로오름차순수열만들기_011 {

    static Stack<Integer> stack = new Stack<>();

    static int findIndex = 0;

    // 연산 출력 저장
   static StringBuffer result = new StringBuffer();

    public static void main(String[] args) {
        
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열 수
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 1부터 N까지 스택에 저장
        for(int i=1; i<=N; i++) {

            // 스택이 비어 있거나 찾는 수보다 작으면 스택에 추가.
            if(stack.empty() || stack.peek() < arr[findIndex]) {
                push(i);
            }
            // 출력할 수 있는 만큼 출력
            while(!stack.empty() && arr[findIndex] == stack.peek()) {
                pop();
            }

            // 찾는 수보다 현재 peek 값이 더 크면 멈춤
            if (!stack.empty() && arr[findIndex] < stack.peek()) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(result.toString());
    }

    public static void push(int i) {
        stack.push(i);
        result.append("+\n");
    }

    public static void pop() {
        stack.pop();
        result.append("-\n");
        findIndex++;
    }

}
