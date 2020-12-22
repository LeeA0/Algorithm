package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준_프린터큐_1966_실버3
public class BOJ_1966_프린터큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] document = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				document[i] = Integer.parseInt(st.nextToken());
			}
			int[] priority = document.clone();
			Arrays.sort(priority);

			int i = N - 1;
			a: while (i >= 0) {
				for (int j = 0; j < N; j++) {
					if (document[j] == priority[i]) {
						if (j == M) {
							break a;
						}
						i--;
					}
				}
			}
			System.out.println(N - i);
		}
	}
}
