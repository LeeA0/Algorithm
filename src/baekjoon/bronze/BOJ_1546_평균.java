package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_평균_1546_브론즈1
public class BOJ_1546_평균 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int max = 0;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(st.nextToken());
			max = Math.max(max, score);
			sum += score;
		}

		double avg = (sum / max * 100) / N;
		System.out.println(avg);
	}
}
