package basic.sort.병합정렬;

import javax.xml.stream.XMLEventFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1517
public class 버블소트프로그램2 {

    // 곧이곧대로 버블 소트를 사용하면 제한 시간을 초과한다.
    // 두 그룹을 병합하는 과정에 버블 정렬의 swap 이 포함되어 있다.

    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {

        // 입력값 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        mergeSort(1, N); // 병합 정렬 수행
        System.out.println(result);
    }

    private static void mergeSort(int s, int e) {
        // index 가 만나면 종료
        if( e - s < 1 ) {
            return;
        }

        int m = s + (e - s) / 2;

        // 재귀 함수 형태로 구현
        mergeSort(s, m);        // 앞 그룹 병합 정렬
        mergeSort(m+1, e);   // 뒷 그룹 병합 정렬

        // 정렬한 값을 tmp 에 초기화
        for(int i=s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int i = s; // 전체 그룹 인덱스
        int index1 = s;     // 앞 그룹 시작 인덱스
        int index2 = m + 1; // 뒷 그룹 시작 인덱스

        // 두 그룹을 병합하는 로직
        while(index1 <= m && index2 <= e) {
            if(tmp[index1] > tmp[index2]) {
                A[i] = tmp[index2];

                // # 뒤쪽 데이터 값이 작은 경우 result 업데이트
                result += index2 - i;

                i++;
                index2++;
            } else {
                A[i] = tmp[index1];
                i++;
                index1++;
            }
        }

        // 한 쪽 그룹이 모두 선택된 후 남아있는 값 정리하기
        while (index1 <= m) {
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
