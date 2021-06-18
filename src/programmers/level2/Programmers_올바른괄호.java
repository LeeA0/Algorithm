package programmers.level2;

import java.util.Stack;

// Programmers_올바른괄호_level2
public class Programmers_올바른괄호 {
	public static void main(String[] args) {
		String s = "()()";
		System.out.println(solution(s));
	}

	/**
	 * ex) ()
	 * 1. 
	 * curr : (
	 * stack:
	 * => push
	 * 2. 
	 * curr : )
	 * stack: (
	 * => pop
	 * 3.
	 * curr :
	 * stack:
	 * => isEmpty? true
	 * 
	 * ex) )(
	 * 1. 
	 * curr : )
	 * stack:
	 * => push
	 * 2.
	 * curr : (
	 * => push
	 * stack: )
	 * 3.
	 * curr:
	 * stack: )(
	 * => isEmpty? false
	 */
	public static boolean solution(String s) {
		// 괄호가 올바른지 판단하기위해 저장할 stack 선언
		Stack<Character> stack = new Stack<Character>();
		// 전체 문자열 조회
		for (int i = 0; i < s.length(); i++) {
			// stack이 비어있지않고, 현재 문자열이 ')'이고, stack의 가장 위에 있는 문자열이 '('일 때 pop
			if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
				stack.pop();
			}
			// 아니면 push
			else {
				stack.push(s.charAt(i));
			}
		}
		// 스택이 비어있으면 올바른 괄호임
		return stack.isEmpty();
	}
}
