package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [최댓값과 최솟값] https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=java
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 *
 * 제한 조건
 * s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 */
public class 최댓값과최솟값 {

    public static void main(String[] args)  {
        String str  = "-1 -2 -3 -4";
        String answer = solution(str);
        System.out.println(answer);
    }

    /*
        개선한 코드
        1. Collections.sort() 대신 최소, 최대 값을 찾기 위해 한 번만 순회한다.
        2. StringBuilder 없이 간단히 문자열을 연결한다.
     */
    public static String solution(String s) {
        String[] strArr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str : strArr) {
            int num = Integer.parseInt(str);
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return min + " " + max;
    }

    /*
        기존 코드
        1. 주어진 문자열을 공백을 기준으로 자른다.
        2. 숫자로 변환하며 ArrayList 에 담는다.
        3. ArrayList 를 오름차순 정렬한다.
        4. 가장 첫번째와 마지막 값을 찾는다.
     */

    public static String old_solution(String s) {
        String answer;
        List<Integer> numList = new ArrayList<>();
        String[] strArr = s.split(" ");

        for(String str : strArr) {
            numList.add(Integer.valueOf(str));
        }

        Collections.sort(numList);

        answer = numList.get(0).toString();
        answer += numList.get(numList.size()-1).toString();
        return answer;
    }
}
