package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준_검문_2981_실버1
// 왜 시간을 때우려고 수학게임을 할까?
public class BOJ_2981_검문 {
	static int N;
	static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine().trim());
		}
		// 입력 완료
		Arrays.sort(num);

		// 전체 숫자에서 제일 작은 수를 빼준다
		for (int i = 1; i < N; i++) {
			num[i] -= num[0];
		}

		// 유클리드 호제법을 이용하여 제일 작은수를 제외한 나머지 숫자들의 최대공약수를 구한다
		int gcd = num[1];
		for (int i = 2; i < N; i++) {
			gcd = GCD(gcd, num[i]);
		}

		// 최대공약수의 약수를 구한다
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= gcd; i++) {
			if (gcd % i == 0) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
	}

	private static int GCD(int a, int b) {
		// 한 수가 0이 될 때까지 나머지 연산을 해줌
		while (a != 0) {
			b %= a;
			// b는 항상 큰 수가 되게 바꿔줌
			int temp = a;
			a = b;
			b = temp;
		}
		return b;
	}
}
