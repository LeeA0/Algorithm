package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_별찍기9_2446_브론즈3
public class BOJ_2446_별찍기9 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N * 2 - 1; i++) {
			for (int j = 0; j < -Math.abs(i-(N-1))+N-1; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < 2*Math.abs(i-(N-1))+1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
