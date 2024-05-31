package basic.sort.버블정렬;

// https://www.acmicpc.net/problem/1377

// 버블 정렬의 swap 이 한번도 일어나지 않은 루프가 언제인지 알아내는 문제
// 안쪽 루프에서 swap 이 일어나지 않는 경우 = 이미 정렬이 된 경우

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 안쪽 for문이 몇 번 수행됐는지 구하는 다른 아이디어
 안 쪽 루프는 왼쪽에서 오른쪽으로 이동하면서 swap 을 수행한다.
 이는 특정 데이터가 안쪽 루프에서 swap 의 왼쪽으로 이동할 수 있는 `최대 거리가 1`이라는 뜻이다.
 즉, 데이터의 정렬 전 index 와 정렬 후 index 를 비교해 왼쪽으로 `가장 많이 이동한 값을 찾으면` 이 문제를 해결할 수 있다.
 //--==>> 한번에 이동할 수 있는 최대 거리가 1 이므로 가장 많이 이동한 값을 찾으면 최소 그때는 정렬이 완료된 것
*/
public class 버블소트_016 {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];
        for(int i=0; i<N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        // A 배열 정렬 O(nlogn)
        Arrays.sort(A);
        int max = 0;
        for(int i=0; i<N; i++) {
            // (정렬 전 index - 정렬 후 index) 계산의 최댓값 저장하기
            if(max < A[i].idx - i) {
                max = A[i].idx -i; // 정렬 전 index - 현재 인덱스
            }
        }
        System.out.println(max + 1); // swap 일어나지 않는 경우 더함(1)
    }

    static class mData implements Comparable<mData> {
        int value;
        int idx;

        public mData(int value, int idx) {
            super();
            this.value = value;
            this.idx = idx;
        }


        @Override
        public int compareTo(mData o)
        {
            // value 기준으로 오름차순 정렬
            return this.value - o.value;
        }
    }
}

