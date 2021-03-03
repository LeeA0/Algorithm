package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준_10828_스택_실버4
public class BOJ_10828_스택 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 값을 넣을 스택 선언
		Stack<String> stack = new Stack<>();
		// 출력 값을 저장할 stringbuilder선언
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				// 스택에 해당 값을 넣는다
				stack.push(st.nextToken());
				break;
			case "pop":
				// 스택이 비어있으면 -1, 아니면 맨 위에있는 것을 빼면서 출력
				sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
				break;
			case "size":
				// 스택의 사이즈를 출력
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				// 스택이 비어있으면 1, 아니면 0 출력
				sb.append(stack.isEmpty()? 1 : 0).append("\n");
				break;
			case "top":
				// 스택이 비어있으면 -1, 아니면 맨 위에 있는 것을 출력
				sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
}
