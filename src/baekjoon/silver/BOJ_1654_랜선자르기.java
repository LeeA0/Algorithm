package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_랜선자르기_1654_실버3
public class BOJ_1654_랜선자르기 {
	static int K, N;
	static long answer;
	static long[] LAN;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		LAN = new long[K];
		long min = Long.MAX_VALUE;
		long sum = 0;
		for (int i = 0; i < K; i++) {
			LAN[i] = Long.parseLong(br.readLine().trim());
			min = Math.min(min, LAN[i]);
			sum += LAN[i];
		}
		long avg = sum / N;

		answer = 0;
		long left = 0;
		long right = avg;
		long mid = avg;

		while (left <= right) {
			int cnt = 0;
			for (int j = 0; j < K; j++) {
				cnt += LAN[j] / mid;
			}
			if (N <= cnt) {
				answer = Math.max(answer, mid);
				left = mid+1;
			} else {
				right = mid-1;
			}
			mid = (left + right) / 2;
		}
		System.out.println(answer);
	}
}
