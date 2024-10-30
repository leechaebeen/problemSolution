package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941#
 * 그리디 알고리즘,
 * 작은 수와 큰 수를 곱할수록 최종 합이 더 작아진다.
 */
public class Lv2_최솟값만들기
{

    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        System.out.println(solution(A, B));
    }

    public static int solution(int []A, int [] B) {
        // 배열 A를 오름차순으로 정렬
        Arrays.sort(A);
        // 배열 B를 우선 오름차순으로 정렬
        Arrays.sort(B);

        int minSum = 0;
        int length = A.length;

        for (int i = 0; i < length; i++) {
            // A의 작은 값과 B의 큰 값(역순으로 순회)을 곱해서 누적
            minSum += A[i] * B[length - i - 1];
        }
        return minSum;
    }
}
