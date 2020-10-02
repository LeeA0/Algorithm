package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_블랙잭_2798_브론즈2
public class BOJ_2798_블랙잭 {
	static int N, M, R = 3, min = 0;
	static int[] card;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		card = new int[N];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		nCr(0, 0, 0);
		System.out.println(min);
	}

	private static void nCr(int cnt, int start, int sum) {
		if (cnt == R) {
			//sum이 M을 넘어가지 않고, min보다 M과의 차이가 작으면
			if (M >= sum && M - min > M - sum) {
				min = sum;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			nCr(cnt + 1, i + 1, sum + card[i]);
		}
	}
}
