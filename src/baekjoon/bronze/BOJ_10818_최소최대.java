package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_최소,최대_10818_브론즈3
public class BOJ_10818_최소최대 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			max = Math.max(max, a);
			min = Math.min(min, a);
		}
		System.out.println(min + " " + max);
	}
}
