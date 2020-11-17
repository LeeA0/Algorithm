package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_알약_4811_골드5
public class BOJ_4811_알약 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] d = new long[30];
		d[0] = 1;
		// dp채우기
		for (int i = 1; i < 30; i++) {
			d[i] = 2*(2*i+1)*d[i-1] / (2+i);
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine().trim());
			if (N == 0) {
				break;
			}
			sb.append(d[N-1]).append("\n");
		}
		System.out.println(sb);
	}

}
