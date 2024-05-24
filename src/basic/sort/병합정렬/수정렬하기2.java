package basic.sort.병합정렬;

import java.io.*;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2751
public class 수정렬하기2 {

    public static int[] A, tmp;

    public static void main(String[] args) throws IOException {
        // 입력값 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];

        for(int i =1; i<=N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(1, N);

        for (int i=1; i<=N; i++) {
            bw.write(A[i] +"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merge_sort(int s, int e) {
        // index 가 만나면 종료
        if(e-s < 1) {
            return;
        }

        int m = s + (e - s) / 2; // 배열을 분할할 기준

        //재귀 함수
        merge_sort(s, m);      // 앞 그룹
        merge_sort(m+1, e); // 뒤 그룹

        for(int i=s; i<=e; i++) {
            tmp[i]=A[i];
        }

        int i = s;          // 전체 그룹 인덱스 시작점
        int index1 = s;     // 앞 그룹 시작점
        int index2 = m+1;   // 뒷 그룹 시작점

        // 두 그룹을 병합하는 로직
        while(index1 <= m && index2 <= e) {
            // 양쪽 그룹의 index 가 가르키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
            // 선택된 데이터의 index 값을 오른쪽으로 한칸 이동하기
            if(tmp[index1] > tmp[index2]) {
                A[i] = tmp[index2];
                i++;
                index2++;
            } else {
                A[i] = tmp[index1];
                i++;
                index1++;
            }
        }

        // 한 쪽 그룹이 모두 선택된 후 남아있는 값 정리하기
        while(index1 <= m) {
            A[i] = tmp[index1];
            i++;
            index1++;
        }
        while(index2 <= e) {
            A[i] = tmp[index2];
            i++;
            index2++;
        }
    }
}
