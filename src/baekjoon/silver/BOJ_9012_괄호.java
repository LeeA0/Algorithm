package baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

//백준_괄호_9012_실버4
public class BOJ_9012_괄호 {
	static int T;
	static char[] str;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 0; t < T; t++) {
			str = scan.next().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < str.length; i++) {
				if (str[i] == '(') {
					stack.push(str[i]);
				} else if (str[i] == ')') {
					if(!stack.isEmpty()&&stack.peek()=='(') {
						stack.pop();
					}else {
						stack.push(str[i]);
					}
				}
			}
			if(stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
