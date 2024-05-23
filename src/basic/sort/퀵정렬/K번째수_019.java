package basic.sort.퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11004
public class K번째수_019 {

    public static void main(String[] args) throws IOException {
        // 입력값 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]); // k 번째 수
    }

    private static void quickSort(int[] A, int S, int E, int K) {
        if(S < E) {
            int pivot = partition(A, S, E);
            // K 번째 수가 pivot 이면 더이상 구할 필요 없음
            if(pivot == K) {
                return;
            }
            // K 가 pivot 보다 작으면 왼쪽 그룹만 정렬 수행하기
            else if(K < pivot) {
                quickSort(A, S, pivot-1, K);
            }
            // K가 pivot 보다 크면 오른쪽 그룹만 정렬 수행하기
            else {
                quickSort(A, pivot+1, E, K);
            }
        }
    }

    // 피벗 구하기 함수
    private static int partition(int[] A, int S, int E) {
        // 데이터가 두 개인 경우 바로 비교하여 정렬
        if(S + 1 == E) {
            if(A[S] > A[E]) {
                swap(A, S, E);
            }
            return E; // 새 피벗의 인덱스
        }
        int M = (S+E)/2;    // 중앙값
        swap(A, S, M);      // 중앙값을 시작 위치와 swap
        int pivot = A[S];   // 피벗을 시작  위치 값 A[S] 로 저장

        int i = S + 1;  // 시작점, 종료점
        int j= E;

        while(i<=j) {
            // 피벗보다 작은 수가 나올 때까지 j--
            while(pivot < A[j] && j > 0) {
                j--;
            }

            // 피벗보다 큰 수가 나올 때까지 i++
            while (pivot > A[i] && i < A.length -1) {
                i++;
            }

            // 찾은 i 와 j 데이터를 swap
            if(i <= j) {
                swap(A, i++, j--);
            }
        }

        // 나눠진 두 그룹의 경계 index 에 피벗 데이터를 설정하기
        A[S] = A[j];
        A[j] = pivot;
        return j;   // 새 피벗의 인덱스
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /*
    // 시간 초과
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        System.out.println(A[K-1]);
    }
    */
}
