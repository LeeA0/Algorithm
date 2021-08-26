package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3003_킹퀸룩비숍나이트폰 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		StringBuilder sb = new StringBuilder();
		int[] chess = { 1, 1, 2, 2, 2, 8 };
		for (int i = 0; i < 6; i++) {
			sb.append(chess[i] - Integer.parseInt(st.nextToken()));
			if (i != 5) {
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
