package programmers.level2;

import java.util.Stack;

// Programmers_괄호변환_level2
public class Programmers_괄호변환 {
	public static void main(String[] args) {
		String p = ")(";
		System.out.println(solution(p));
	}

	public static String solution(String p) {
		// 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다
		if (p.equals("")) {
			return "";
		}
		
		// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다
		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();
		// '('의 개수
		int a_num = 0;
		// ')'의 개수
		int b_num = 0;
		for (int i = 0; i < p.length(); i++) {
			// '('와')'의 개수가 0이 아니고,개수가 같을 때 나머지 문자열을 v에 저장 후 break 
			if (a_num != 0 && b_num != 0 && a_num == b_num) {
				v.append(p.substring(i, p.length()));
				break;
			}
			// u에 해당 문자 저장
			u.append(p.charAt(i));
			// 개수 카운트
			if (p.charAt(i) == '(') {
				a_num++;
			} else {
				b_num++;
			}
		}
		StringBuilder answer = new StringBuilder();
		// 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다
		//  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다
		if (isCorrect(u.toString())) {
			return answer.append(u.toString()).append(solution(v.toString())).toString();
		}
		// 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다
		//  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
		//  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
		//  4-3. ')'를 다시 붙입니다. 
		//  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
		//  4-5. 생성된 문자열을 반환합니다.
		return answer.append("(").append(solution(v.toString())).append(")")
				.append(reverse(u.substring(1, u.length() - 1))).toString();
	}

	// 괄호 뒤집기
	private static String reverse(String u) {
		StringBuilder reverseSb = new StringBuilder();
		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				reverseSb.append(")");
			} else {
				reverseSb.append("(");
			}
		}
		return reverseSb.toString();
	}

	// 올바른 괄호 문자열인지 체크
	private static boolean isCorrect(String u) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			} else {
				stack.push(u.charAt(i));
			}
		}
		return true;
	}
}
