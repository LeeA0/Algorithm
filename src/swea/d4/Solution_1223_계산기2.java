package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//SW_계산기2_1223_D4
public class Solution_1223_계산기2 {
	static int T = 10, N;
	static char[] infix, postfix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			Stack<Character> stack = new Stack<>();
			infix = new char[N];
			postfix = new char[N];
			int count = 0;
			infix = br.readLine().trim().toCharArray();
			//후위표기법으로 변경
			for (int i = 0; i < N; i++) {
				if (!Character.isDigit(infix[i])) {
					if (stack.isEmpty()) {
						stack.push(infix[i]);
					} else {
						while(true) {
							if (!stack.isEmpty()&&(infix[i] == stack.peek()||infix[i]=='+')) {
								postfix[count] = stack.pop();
								count++;
								}
							else {
								break;
							}
						}
						stack.push(infix[i]);
					}
				} else {
					postfix[count] = infix[i];
					count++;
				}
			}
			while(!stack.isEmpty()) {
				postfix[count] = stack.pop();
				count++;
			}
			stack.clear();
			Stack<String> stack2 = new Stack<>();
			//계산
			for (int i = 0; i < N; i++) {
				if(Character.isDigit(postfix[i])) {
					stack2.push(Character.toString(postfix[i]));
				}else {
					String a = stack2.pop();
					String b = stack2.pop();
					int a_i = Integer.parseInt(a);
					int b_i = Integer.parseInt(b);
					if(postfix[i]=='+') {
						stack2.push(Integer.toString(a_i+b_i));
					}else if(postfix[i]=='*') {
						stack2.push(Integer.toString(a_i*b_i));
					}
				}
			}
			StringBuilder sb = new StringBuilder("#").append(t).append(" ").append(stack2.pop());
			System.out.println(sb.toString());
		}
	}
}
