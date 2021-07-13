package programmers.level2;

import java.util.Stack;

// Programmers_괄호회전하기_level2
public class Programmers_괄호회전하기 {
	public static void main(String[] args) {
		String s = "[](){}";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		// 정답을 저장하는 변수
		int answer = 0;
		// 배열 회전을 위해 문자열을 문자배열로 변환
		char[] c = s.toCharArray();
		// 시작 지점을 옮겨줌으로서 왼쪽으로 회전하는 것과 같은 효과
		for (int start = 0; start < c.length; start++) {
			// 맞는 괄호가 들어오면 제거해주기 위해 stack을 사용
			Stack<Character> stack = new Stack<Character>();
			// 시작 지점 부터 차례로 연산
			for (int i = start; i < start + c.length; i++) {
				// i가 c의 길이를 벗어낫을 때 한바퀴 회전해서 가리킬 수 있도록 나머지 연산
				int idx = i % c.length;
				// stack이 비어있지않고, 괄호의 짝이 맞으면 pop
				if (!stack.isEmpty() && ((stack.peek() == '{' && c[idx] == '}')
						|| (stack.peek() == '(' && c[idx] == ')') || (stack.peek() == '[' && c[idx] == ']'))) {
					stack.pop();
				} 
				// 아니면 맞는 짝이 나타날 때까지 stack에 push
				else {
					stack.push(c[idx]);
				}
			}
			// stack이 비어있으면 올바른 괄호 식이므로 1을 증가
			if (stack.isEmpty()) {
				answer++;
			}
		}

		return answer;
	}
}
