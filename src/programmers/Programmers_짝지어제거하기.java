package programmers;

import java.util.Stack;

// Programmers_짝지어제거하기_level2
public class Programmers_짝지어제거하기 {
	public static void main(String[] args) {
		String s = "abab";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		// String을 문자 배열로 변환
		char[] c = s.toCharArray();

		// 차례로 쌓으면서 문자를 지울 stack을 생성
		Stack<Character> stack = new Stack<>();
		// 문자를 하나씩 넣어본다
		for (int i = 0; i < c.length; i++) {
			// stack이 비어있지않고, 맨 위의 문자와 비교해서 같으면 pop
			if (!stack.isEmpty() && stack.peek() == c[i]) {
				stack.pop();
			}
			// 아니면 push
			else {
				stack.push(c[i]);
			}
		}
		
		// stack이 비어있으면 1, 아니면 짝짓기에 실패했으므로 0
		return stack.isEmpty() ? 1 : 0;
	}

// 정규식 쓰면 시간 초과 난다..!
//	public static int solution(String s) {
//		String pre = s;
//		String curr = s;
//		while (!curr.equals("")) {
//			curr = curr.replaceAll("(\\D)\\1", "");
//			if (pre.equals(curr)) {
//				break;
//			}
//			pre = curr;
//		}
//
//		return curr.equals("") ? 1 : 0;
//	}
}
