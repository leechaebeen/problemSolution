package basic.search.DFS;

import java.util.Scanner;

public class 신기한소수찾기_024 {

    // 자릿수
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 일의 자리 소수는 2,3,5,7 이므로 4개 수에서만 시작
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    static void DFS(int number, int jarisu) {
        // 지정한 자릿수이면 재귀함수 종료(소수이면 출력, 아니면 그냥 종료)
        if(jarisu == N) {
            if(isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        // 일의 자리에 수 붙이기
        for(int i = 1; i < 10; i++) {
            // 짝수라면 소수가 아니므로 탐색 종료
            if(i % 2 == 0) {
                continue;
            }
            // 소수라면 재귀함수로 자릿수를 늘림
            if(isPrime(number * 10 + i)) {
                DFS(number * 10 + i, jarisu+1);
            }
        }
    }

    static boolean isPrime(int num) {
        for(int i = 2; i<= num/2; i++) {
            // 나누어 떨어 지면 소수가 아님
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
