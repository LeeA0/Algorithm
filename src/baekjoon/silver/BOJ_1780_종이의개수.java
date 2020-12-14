package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_종이의개수_1780_실버2
public class BOJ_1780_종이의개수 {
	static int N;
	static int[] cnt;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = new int[3];
		boolean check = true;
		int flag = map[0][0];
		a: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (flag != map[i][j]) {
					check = false;
					break a;
				}
			}
		}
		if (!check) {
			divide(N, 0, 0);
		} else {
			cnt[flag + 1]++;
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}

	private static void divide(int length, int sx, int sy) {
		length /= 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boolean check = true;
				int flag = map[i * length + sx][j * length + sy];
				a: for (int k = i * length + sx; k < i * length + length + sx; k++) {
					for (int l = j * length + sy; l < j * length + length + sy; l++) {
						if (flag != map[k][l]) {
							divide(length, i * length + sx, j * length + sy);
							check = false;
							break a;
						}
					}
				}
				if (check) {
					cnt[flag + 1]++;
				}
			}
		}
	}
}
