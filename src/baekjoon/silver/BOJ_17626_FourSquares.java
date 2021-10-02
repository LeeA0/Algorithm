package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_17626_FourSquares_실버4
public class BOJ_17626_FourSquares {

	static int[] squares;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxSquare = (int) Math.sqrt(n);
		squares = new int[maxSquare + 1];
		for (int i = maxSquare; i > 0; i--) {
			squares[i] = i * i;
		}

		answer = 4;

		getSquares(0, n);

		System.out.println(answer);
	}

	// return type이 boolean인 이유
	// cnt가 answer과 같은 상태면 더 작은 숫자는 당연히 cnt가 answer보다 같거나 크기때문에 더 볼 필요가 없음
	public static boolean getSquares(int cnt, int remain) {
		if (cnt >= answer) {
			return false;
		}
		if (remain == 0) {
			answer = cnt;
			return true;
		}
		int maxSquare = (int) Math.sqrt(remain);
		for (int i = maxSquare; i > 0; i--) {
			if (!getSquares(cnt + 1, remain - squares[i])) {
				break;
			}
		}
		return true;
	}
}
