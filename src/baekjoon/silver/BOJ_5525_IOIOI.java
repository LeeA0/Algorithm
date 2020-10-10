package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_IOIOI_5525_실버2
public class BOJ_5525_IOIOI {
	static int N, M, answer;
	static char[] S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		answer = 0;
		if (N < 500000) {
			M = Integer.parseInt(br.readLine().trim());
			S = br.readLine().trim().toCharArray();
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				if ((S[i] == 'I' && cnt % 2 == 0) || (S[i] == 'O' && cnt % 2 == 1)) {
					cnt++;
				} else if (S[i] == 'I') {
					cnt = 1;
				} else {
					cnt = 0;
				}
				if(cnt>=2*N+1) {
					if(S[i]=='I') {
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
