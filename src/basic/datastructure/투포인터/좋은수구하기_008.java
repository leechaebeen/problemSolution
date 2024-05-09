package basic.datastructure.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 조건 : 수의 위치가 다르면 값이 같아도 다른 수이다.
public class 좋은수구하기_008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;

        for(int i=0; i<N; i++) {
            long niceNumber = arr[i];
            int firstIndex = 0;
            int lastIndex = N-1;

            while(firstIndex < lastIndex) {
                long sum = arr[firstIndex] + arr[lastIndex];
                if( sum < niceNumber) {
                    firstIndex++;
                } else if (sum > niceNumber) {
                    lastIndex--;
                } else {
                    // 서로 다른 두 수의 합이어야 한다.
                    if(firstIndex !=i && lastIndex != i) {
                        count++;
                        break;
                    }
                    // 더이상 찾을 필요 없음
                    else if(firstIndex == i) {
                        firstIndex++;
                    } else if (lastIndex == i) {
                        lastIndex--;
                    }
                }
            }
        }


        System.out.println(count);
        br.close();
    }
}
