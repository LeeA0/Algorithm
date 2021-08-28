package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4153_직각삼각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int[] side = new int[3];
			for (int i = 0; i < 3; i++) {
				side[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(side);
			if (side[0] == 0) {
				break;
			}
			sb.append(side[0] * side[0] + side[1] * side[1] == side[2] * side[2] ? "right" : "wrong").append("\n");
		}
		System.out.println(sb.toString());
	}
}
