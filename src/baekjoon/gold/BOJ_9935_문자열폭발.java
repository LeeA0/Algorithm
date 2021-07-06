package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ_9935_문자열폭발_골드4
public class BOJ_9935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열
		String s = br.readLine();
		// 폭발 문자열
		String bomb = br.readLine();
		// 폭발 문자열의 마지막 문자
		Character bombLast = bomb.charAt(bomb.length() - 1);
		// 문자열을 저장할 스택
		Stack<Character> stack = new Stack<Character>();
		// 문자열 전체를 조회
		for (int i = 0; i < s.length(); i++) {
			// 해당 인덱스의 문자를 스택에 저장
			stack.push(s.charAt(i));
			// 해당 인덱스의 문자와 폭발 문자열의 마지막 문자가 같으면 스택에 저장된 문자가 폭발문자열인지 검사
			if (s.charAt(i) == bombLast) {
				// 폭발 문자열인지 여부
				boolean flag = true;
				// 폭발 문자열인지 알기위해 조회
				for (int j = 0; j < bomb.length(); j++) {
					// 남은 문자열이 폭발 문자열보다 짧거나
					// 폭발 문자열이 아닌 경우 플래그를 false로 해주고 멈춤
					if (stack.size() <= j || stack.get(stack.size() - j - 1) != bomb.charAt(bomb.length() - j - 1)) {
						flag = false;
						break;
					}
				}
				// 폭발 문자열이면 스택에서 제거
				if (flag) {
					for (int b = 0; b < bomb.length(); b++) {
						stack.pop();
					}
				}
			}
		}

		// 스택이 비어있으면 FRULA를 출력
		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} 
		// 아니면 스택에 남은 문자열을 출력
		else {
			StringBuilder sb = new StringBuilder();
			for (char c : stack) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}
}
