package basic.sort.기수정렬;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/10989
public class 수정렬하기3_022 {

    public static int[] A;

    public static void main(String[] args) throws IOException {
        // 입력값 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        // 기수 정렬
        radixSort(A, 5);

        for(int i=0; i<N; i++) {
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] A, int maxJarisu) {
        int[] output = new int[A.length]; // 정렬한 배열
        int jarisu  = 1;
        int count = 0;

        // 최대 자릿수만큼 반복하기
        while(count != maxJarisu) {
           int[] bucket = new int[10]; // 현재 자릿수들의 분포를 합 배열의 형태로 알려 주는 배열
           
           // 현재 기준 자릿수를 기준으로 A 배열 데이터를 bucket 에 count
            // 일의 자리부터 시작하기
           for(int i=0; i<A.length; i++) {
               bucket[(A[i]/jarisu) % 10]++;
           }
            // 합 배열 공식으로 bucket 을 합 배열 형태로 변경하기
            // 합 배열을 이용해 index 계산하기
           for(int i=1; i<10; i++) {
               bucket[i] += bucket[i -1];
           }

           // A = [215, 15, 344, 372]
           // bucket = [0,0,1,1,2,4,4,4,4,4] -> 값의 max 가 대상 배열의 개수
           // bucket 값을 인덱스로 이용해 현재 기준 자릿수로 데이터를 정렬하기 --> 핵심!
            // 정렬된 값을 output 배열에 저장하기
           for(int i = A.length -1; i>=0; i--) {
               output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
               bucket[(A[i] / jarisu) % 10]--;
           }

            // 다음 자릿수로 이동하기 위해 현재 자릿수 기준 정렬 데이터를 A 배열에 저장하기.
           for(int i=0; i < A.length; i++) {
               A[i] = output[i];
           }
           // 자릿수 증가시키키
           jarisu = jarisu * 10;
           count++;
        }

    }
}
