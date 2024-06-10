package basic.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1931
public class 회의실배정하기_035 {

    public static void main(String[] args) {

        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 회의 수
        int[][] A = new int[N][2]; // 주어진 회의 정보
        for(int i=0; i<N; i++) {
            A[i][0] = sc.nextInt(); // 시작 시간
            A[i][1] = sc.nextInt(); // 종료 시간
        }

        // 정렬
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료 시간이 같은 경우
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0]; // 시작 시간이 빠른 순으로 정렬 - 시작 시간과 종료 시간이 같은 경우도 있으므로
                }
                return o1[1] - o2[1]; // 종료 시간이 빠른 순으로 정렬
            }
        });

        int count = 0;
        int end = -1;

        // 회의 수만큼 반복
        for(int i=0; i<N; i++) {
            // 회의 시작 시간이 종료 시간보다 같거나 이후인 경우 (겹치지 않는 다음 회의가 나온 경우)
            if(A[i][0] >= end) {
                end = A[i][1]; // 현재 회의 시간의 종료 시간으로 종료시간 업데이트
                count++;
            }
        }

        System.out.println(count);
    }
}
