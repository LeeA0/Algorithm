package baekjoon.silver;

import java.util.Scanner;

//백준_일어버린 괄호_1541_실버2
public class BOJ_1541_잃어버린괄호 {
	static char[] str;
	static int min;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		str = scan.next().toCharArray();

		min = 0;
		int temp = 0;

		StringBuilder sb = new StringBuilder();
		// 뒤에서 부터 읽음
		// 12-15-16+50-10
		for (int i = str.length - 1; i >= -1; i--) {
			if (i == -1) {
				//마지막. 12까지 다읽었으면 min에 더해줌.
				temp += Integer.parseInt(sb.reverse().toString());
				min += temp;
			} else if (str[i] == '+') {
				// 4. reverse를 이용해 50으로 바꾼 후 temp에 저장(다음에 -가 나왔을 때 다같이 더해서 -로 바꿔주기 위함)
				temp += Integer.parseInt(sb.reverse().toString());
				sb.delete(0, sb.length());
			} else if (str[i] == '-') {
				// 2. reverse를 이용해 10으로 바꾼 후 temp에 더하고 -로 바꾼 뒤 최종 답인 min에 더함.
				// temp = 10
				// min = -10
				// 6. reverse를 이용해 16으로 바꾼 후 temp에 있는 50과 더한 후 -로 바꾼 뒤 min에 더함.
				// 반복~
				temp += Integer.parseInt(sb.reverse().toString());
				sb.delete(0, sb.length());
				min -= temp;
				temp = 0;
			} 
			// 1. 10이 01로 읽힘
			// 3. 50이 05로 읽힘
			// 5. 16이 61로 읽힘
			else {
				sb.append(str[i]);
			}
		}
		System.out.println(min);
	}
}