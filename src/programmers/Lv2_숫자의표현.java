package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 * Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
 *
 * 1 + 2 + 3 + 4 + 5 = 15
 * 4 + 5 + 6 = 15
 * 7 + 8 = 15
 * 15 = 15
 * 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 *
 * 제한사항
 * n은 10,000 이하의 자연수 입니다.
 * 입출력 예
 * n	result
 * 15	4
 * 입출력 예 설명
 * 입출력 예#1
 * 문제의 예시와 같습니다.
 */
public class Lv2_숫자의표현 {

    // 1) 값을 1씩 증가시키면서 n과 같거나 클 때까지 더한다.
    // 2) 더한 값이 n 과 같으면 answer++, n 보다 크면 다음으로 넘어간다.
    // 2) 시작값도 1씩 증가한다.

    // 1 + 2 + 3 + 4 + 5 == 15 (o)
    // 2 + 3 + 4 + 4 + + 5 + 6 > 15 (x)
    // 3 + 4 + 5 + 6 > 15 (x)
    // 4 + 5 + 6 == 15 (o)
    // 5 + 6 + 7 > 15 (x)
    // 6 + 7 + 8 > 15 (x)
    // ...
    // 15 == 15(o)
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;

        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=1+i; j<=n; j++) {
                sum += j;
                System.out.println("sum = " + sum + " j : " + j);
                if(sum == n) {
                    answer++;
                    break;
                } else if(sum > n) {
                    break;
                }
            }
        }

        return answer;
    }

    // 시작점을 0 으로 초기화하는 문제 있음
    private static int old_solution(int n) {
        int answer = 0;

        int num = 1;
        int sum = 0;
        while(num <= n) {

            sum += num;
            if(sum == n) {
                answer++;
                num++;
            } else if(sum > n) {
                num++;
                sum = 0;
            }
        }

        return answer;
    }
}
