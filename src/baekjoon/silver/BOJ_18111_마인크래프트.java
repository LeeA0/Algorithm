package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_마인크래프트_18111_실버3
public class BOJ_18111_마인크래프트 {

	static int N, M, B, min_time, max_height;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}

		min_time = Integer.MAX_VALUE;
		max_height = 0;

		// 최종 목표치를 제일 낮은 값에서 제일 높은 값으로 올려주며 제일 낮은 시간값을 구해준다.
		// 높이는 시간이 같은경우 제일 높은 값을 출력하라 했으므로 나중에 덧씌워지도록해준다.
		for (int h = min; h <= max; h++) {
			int time = 0;
			int temp_b = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (h < map[i][j]) {
						time += 2 * (map[i][j] - h);
						temp_b += map[i][j] - h;
					} else if (h > map[i][j]) {
						time += h - map[i][j];
						temp_b -= h - map[i][j];
					}
				}
			}
			if (temp_b >= 0) {
				//같은 시간인데 높이가 클 때 덧씌울 수 있어야함.
				if (min_time >= time) {
					min_time = time;
					max_height = h;
				}
			}
		}

		System.out.println(min_time + " " + max_height);
	}
}