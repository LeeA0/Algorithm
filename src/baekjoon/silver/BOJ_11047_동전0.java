package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_동전0_11047_실버1
public class BOJ_11047_동전0 {
	static int N, K;
	static int[] coin;

	public static void main(String[] args) throws Exception {
		// dp?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine().trim());
		}

		for (int i = N - 1; i >= 0; i--) {
			if (coin[i] <= K) {
				cnt += K / coin[i];
				K %= coin[i];
			}
		}
		
		System.out.println(cnt);
	}

}
