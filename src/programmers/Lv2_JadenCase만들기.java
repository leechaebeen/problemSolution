package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 *
 * 문제 설명
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * s는 길이 1 이상 200 이하인 문자열입니다.
 * s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
 * 숫자는 단어의 첫 문자로만 나옵니다.
 * 숫자로만 이루어진 단어는 없습니다.
 * 공백문자가 연속해서 나올 수 있습니다.
 *
 */
public class Lv2_JadenCase만들기 {

    static boolean isFirstChar = true;

    public static void main(String[] args) {
        String str = "3people  unFollowed me";
        String str2 = "for the last week";

        System.out.println(solution(str));
        System.out.println(solution(str2));
    }

    private static String solution(String s) {

        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            // 공백 문자인 경우 flag true 로 변경
            if(String.valueOf(charArr[i]).isBlank()) {
                isFirstChar = true;
                continue;
            }
            char newCh = changeCase(charArr[i]);
            charArr[i] = newCh;
            isFirstChar = false;
        }

        // 다음 케이스를 위해 static 변수 초기화
        // (static 변수는 ide 에서 편하게 실행하기 위해 사용한 것이으모 프로그래머스에 제출할 땐 필요하지 않음)
        isFirstChar = true;
        return String.valueOf(charArr);

    }

    /**
     * 조건에 맞게 치환한다.
     */
    private static char changeCase(char ch) {
        char result = ch;

        // 첫 문자인데 소문자이면 대문자로 치환
        if(isFirstChar && Character.isLowerCase(ch)) {
            result = Character.toUpperCase(ch);
        }
        // 첫 문자가 아닌데 대문자이면 소문자로 치환
        else if(!isFirstChar && Character.isUpperCase(ch)) {
            result = Character.toLowerCase(ch);
        }

        return result;
    }

    /**
     * 첫 답안
     * 연속된 공백을 고려하지 않았다.
     */
    private static String old_solution(String s) {

        StringBuilder answer = new StringBuilder();

        // 공백으로 자르기
        String[] strArr = s.split(" ");
        for(int i=0; i < strArr.length; i++) {
            // 처음과 끝이 공백이거나, 연속한 공백 문자인 경우
            if(strArr[i].isBlank()) {
                answer.append(strArr[i]);
                continue;
            }

            char[] chArr = strArr[i].toCharArray();
            for(int j=0; j< chArr.length; j++) {
                char ch = chArr[j];
                // 숫자인 경우 넘어감
                if(Character.isDigit(ch)) {
                    continue;
                }
                // 첫 글자가 소문자이면 대문자로 치환
                if(j == 0 && Character.isLowerCase(ch)) {
                    chArr[j] = Character.toUpperCase(ch);
                }
                // 첫글자가 아닌데 대문자이면 소문자로 치환
                else if(j != 0 && Character.isUpperCase(ch)) {
                    chArr[j] = Character.toLowerCase(ch);
                }
            }
            answer.append(chArr).append(" ");
        }
        return answer.toString();
    }
}
