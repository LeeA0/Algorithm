package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//백준_스택수열_1874_실버3
public class BOJ_1874_스택수열 {
	static int N;
	static int[] Sequence;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int index = 1;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine().trim());
			for (; index <= a; index++) {
				stack.push(index);
				sb.append("+").append("\n");
			}
			if(stack.peek()==a) {
				stack.pop();
				sb.append("-").append("\n");
			}
		}
		if(stack.empty()) {
			System.out.println(sb.toString());
		}else {
			System.out.println("NO");
		}
	}
}
