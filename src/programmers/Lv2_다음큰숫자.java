package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 *
 * [문제 설명]
 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
 *
 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 *
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 *
 * [제한 사항]
 * n은 1,000,000 이하의 자연수 입니다.
 *
 * [입출력 예]
 * n	result
 * 78	83
 * 15	23
 */
public class Lv2_다음큰숫자 {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }

    private static int solution(int n) {
        int countOfOnes = Integer.bitCount(n); // n의 1의 개수
        int answer = n + 1;

        // 1의 개수가 동일한 숫자를 찾을 때까지 반복
        while (Integer.bitCount(answer) != countOfOnes) {
            answer++;
        }
        return answer;
    }

    private static int solution_old (int n) {
        int answer = 0;

        int count = countOneInString(changeToBinary(n).toString());

        while (true) {
            n++;
            if(count == countOneInString(changeToBinary(n).toString())) {
                answer = n;
                break;
            };
        }

        return answer;
    }

    // 주어진 수를 이진법으로 변환
    private static StringBuilder changeToBinary(int n) {
        StringBuilder sb = new StringBuilder();

        while(n>1) {
            sb.insert(0, n % 2);
            n = n / 2;
        }

        return sb;
    }

    private static int countOneInString(String s) {
        int answer = 0;
        String[] strArr = s.split("");
        for(String str : strArr) {
            if(str.equals("1")) {
                answer++;
            }
        }
        return answer;
    }
}
