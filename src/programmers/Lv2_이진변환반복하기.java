package programmers;

import java.util.Arrays;

/**
 * [이진변환 반복하기]
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 *
 * 문제 설명
 * 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
 *
 * x의 모든 0을 제거합니다.
 * x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
 * 예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
 *
 * 0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때
 * , 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * s의 길이는 1 이상 150,000 이하입니다.
 * s에는 '1'이 최소 하나 이상 포함되어 있습니다.
 * 입출력 예
 * s	result
 * "110010101001"	[3,8]
 * "01110"	[3,3]
 * "1111111"	[4,1]
 */
public class Lv2_이진변환반복하기 {

    private static int countZero = 0;
    private static int countChange = 0;

    public static void main(String[] args) {

        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
        System.out.println(Arrays.toString(solution(s3)));

    }

    private static int[] solution(String s) {
        int[] result = new int[2];

        // 1. s 의 모든 0을 제거한다
        // 2. 0  을 제거한 s 의 길이의 수를 이진법으로 변환한다.
        // 3. s 가 1이 될 때까지 1,2를 반복한다.
        do {
            String noZeroStr = removeZero(s);
            int n = noZeroStr.length();
            s = toBinary(n);
        } while(!s.equals("1"));

        result[0] = countChange;
        result[1] = countZero;

        // static 이므로 초기화 필요
        countChange = 0;
        countZero = 0;
        return result;
    }

    // 0 없앤 문자열 반환
    private static String removeZero (String s) {
        StringBuilder newStr = new StringBuilder();
        String[] arr = s.split("");
        for(int i=0; i < arr.length; i++) {
            if(arr[i].equals("0")) {
                countZero++;
            }
            else {
                newStr.append(arr[i]);
            }
        }
        return newStr.toString();
    }

    // 이진 변환
    private static String toBinary(int n) {
        countChange++;
        if (n == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n = n / 2;
        }
        return binary.toString();
    }
}
