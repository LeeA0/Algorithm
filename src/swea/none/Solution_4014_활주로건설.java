package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_활주로건설_4014
public class Solution_4014_활주로건설 {

	static int T, N, X;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 완료

			int answer = 0;
			// 가로방향 세기
			for (int i = 0; i < N; i++) {
				boolean canCount = true;
				boolean[] check = new boolean[N]; // 경사로체크
				for (int j = 0; j < N - 1; j++) {
					// 평탄한 공간은 그냥 패스
					if (map[i][j] == map[i][j + 1]) {
						continue;
					}
					// 높은 곳에서 낮은 곳으로 가면 (높이차 1)
					else if (map[i][j] - map[i][j + 1] == 1) {
						// 이후 칸으로 이동하며 경사로를 놓을 수 있는 지 체크
						j++;
						check[j] = true;
						int xcount = 1;
						while (j < N - 1) {
							if (map[i][j] == map[i][j + 1]) {
								xcount++;
								check[j + 1] = true;
							} else {
								break;
							}
							if(xcount==X) {
								break;
							}
							j++;
						}
						if (xcount < X) {
							canCount = false;
							break;
						}
						j--;
					}
					// 낮은 곳에서 높은 곳으로 가면 (높이차 1)
					else if (map[i][j] - map[i][j + 1] == -1) {
						// 이전 칸으로 이동하며 경사로를 놓을 수 있는 지 체크
						int k = j;
						int xcount = 1;
						while (k > 0) {
							if (!check[k] && !check[k - 1] && (map[i][k] == map[i][k - 1])) {
								xcount++;
							} else {
								break;
							}
							if(xcount==X) {
								break;
							}
							k--;
						}
						if (xcount < X) {
							canCount = false;
							break;
						}
					}
					// 높이차가 1이상일 때
					else {
						canCount = false;
						break;
					}
				}
				if (canCount) {
					//System.out.println("가로" + i);
					answer++;
				}
			}
			// 세로 방향 세기
			for (int i = 0; i < N; i++) {
				boolean canCount = true;
				boolean[] check = new boolean[N]; // 경사로체크
				for (int j = 0; j < N - 1; j++) {
					// 평탄한 공간은 그냥 패스
					if (map[j][i] == map[j + 1][i]) {
						continue;
					}
					// 높은 곳에서 낮은 곳으로 1칸 가면 (높이차 1)
					else if (map[j][i] - map[j + 1][i] == 1) {
						// 이후 칸으로 이동하며 경사로를 놓을 수 있는 지 체크
						j++;
						check[j] = true;
						int xcount = 1;
						while (j < N - 1) {
							if (map[j][i] == map[j + 1][i]) {
								xcount++;
								check[j + 1] = true;
							} else {
								break;
							}
							if(xcount==X) {
								break;
							}
							j++;
						}
						if (xcount < X) {
							canCount = false;
							break;
						}
						j--;
					}
					// 낮은 곳에서 높은 곳으로 가면 (높이차 1)
					else if (map[j][i] - map[j + 1][i] == -1) {
						// 이전 칸으로 이동하며 경사로를 놓을 수 있는 지 체크
						int k = j;
						int xcount = 1;
						while (k > 0) {
							if (!check[k] && !check[k - 1] && (map[k][i] == map[k - 1][i])) {
								xcount++;
							} else {
								break;
							}
							if(xcount==X) {
								break;
							}
							k--;
						}
						if (xcount < X) {
							canCount = false;
							break;
						}
					}
					// 높이차가 1이상일 때
					else {
						canCount = false;
						break;
					}
				}
				if (canCount) {
					//System.out.println("세로" + i);
					answer++;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
