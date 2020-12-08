package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_별찍기3_브론즈3
public class BOJ_2440_별찍기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
