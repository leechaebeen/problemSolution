package basic.datastructure.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 갑옷은 두 개의 재료로 만든다.
public class 주몽의명령_007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIndex = 0;
        int endIndex = N-1;
        int count = 0;

        // 정렬
        Arrays.sort(arr);

        while(startIndex < endIndex){
            int sum = arr[startIndex] + arr[endIndex];
            if(sum == M) {
                count++;
                startIndex++;
                endIndex--; // start만 이동하면 무조건 큰 수가 되기 때문에
            } else if (sum < M) {
                startIndex++;
            } else if (sum > M) {
                endIndex--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
