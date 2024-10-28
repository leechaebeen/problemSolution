package programmers;

import java.util.Stack;

/**
 * [올바른 괄호] https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
 *
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 문자열 s의 길이 : 100,000 이하의 자연수
 * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 */
public class 올바른괄호 {

    public static void main(String[] args) {
        String str = "(())()";
        System.out.println(isValid(str));
    }

    // 스택에는 여는 괄호만 추가한다.
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray())
        {
            // 여는 괄호는 스택에 추가
            if (ch == '(')
            {
                stack.push(ch);
                // 닫는 괄호는 스택의 여는 괄호를 꺼내기
            } else if (ch == ')')
            {

                // 스택이 비어있는데 닫는 괄호가 나온 경우 올바르지 않음
                if (stack.isEmpty())
                {
                    return false;
                }
                stack.pop();
            }
        }

        // 문자 배열을 한번 돌면 스택이 비어 있어야 함
        return stack.isEmpty();
    }

}


