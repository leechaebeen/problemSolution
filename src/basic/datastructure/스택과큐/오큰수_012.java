package basic.datastructure.스택과큐;

import java.io.*;
import java.util.Stack;

public class 오큰수_012 {


    // https://www.acmicpc.net/problem/17298

    public static void main(String[] args) throws IOException {

        // 1. 스택에 새로 들어오는 수가 peek() 보다 크면 그 수는 오큰수가 된다.
        // 2. 오큰수를 구한 후 수열에서 오큰수가 존재하지 않는 숫자에 -1을 출력해야 한다.

        // 입력값 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];     // 수열 배열
        int[] result = new int[N];  // 정답 배열

        String[] str = br.readLine().split(" ");
        for(int i=0; i< N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            result[i] = -1;
        }

        // 처음에는 스택이 항상 비어있으므로 최초 수열의 인덱스 값을 push 한다.
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1; i<N; i++) {
            // 스택이 비어있지 않고 현재 수열이 top 인덱스가 가르키는 수열보다 클 경우
            while(!stack.empty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i); // 다음 수열의 인덱스 push
        }

        // 출력 수가 많기 때문에 반복문을 돌려 System.out 진행 시 너무 느림
        // StringBuilder를 통해 한번에 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(result[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }

}
