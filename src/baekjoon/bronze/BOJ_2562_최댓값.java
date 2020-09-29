package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_최댓값_2562_브론즈2
public class BOJ_2562_최댓값 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			int a = Integer.parseInt(br.readLine().trim());
			if (a > max) {
				max = a;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
	}
}
