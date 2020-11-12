package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_격자상의 경로_10164_실버1
public class BOJ_10164_격자상의경로 {
	static int N, M, K;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 1;

		map = new int[N][M];
		int kx;
		int ky;
		// K가 있을 때0
		if (K != -1) {
			kx = K / M;
			ky = K % M;
		}
		// K가 없을 때
		else {
			kx = N - 1;
			ky = M - 1;
		}
		// K를 방문하지 않았을 때
		for (int i = 0; i <= kx; i++) {
			for (int j = 0; j <= ky; j++) {
				if (i == 0) {
					map[i][j] = 1;
				} else if (j == 0) {
					map[i][j] = 1;
				} else {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
		}
		// K를 방문한 이후
		for (int i = kx; i < N; i++) {
			for (int j = ky; j < M; j++) {
				if (i == 0) {
					map[i][j] = 1;
				} else if (j == 0) {
					map[i][j] = 1;
				} else {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
		}

		System.out.println(map[N - 1][M - 1]);
	}
}
