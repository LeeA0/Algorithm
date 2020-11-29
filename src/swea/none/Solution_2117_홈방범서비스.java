package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//집을 다이아몬드의 맨 위로 가게 배치 -> 실패
//그냥 배열점을 중심으로 전체 탐색->성공
//SW_홈 방법 서비스_2117
public class Solution_2117_홈방범서비스 {
	static int T, N, M, answer;
	static int[][] map;
	static int[] cost;
	static LinkedList<int[]> homelist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			homelist = new LinkedList<int[]>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						homelist.add(new int[] { i, j });
					}
				}
			}

			cost = new int[22];
			for (int i = 1; i < 22; i++) {
				cost[i] = i * i + (i - 1) * (i - 1);
			}

			answer = 0;

			int ksize;
			if (N % 2 == 0) {
				ksize = N + 1;
			} else {
				ksize = N;
			}
			// k설정
			for (int k = 1; k <= ksize; k++) {
				// 집을 맨위로 설정하여 k범위만큼 탐색
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < N; y++) {

						int count = 0;// 범위안에 집 개수 카운트
						// 다이아몬드 탐색
						for (int i = -(k - 1); i <= k - 1; i++) {
							for (int j = Math.abs(i) - (k - 1); j <= k - 1 - Math.abs(i); j++) {
								if (!check(x + i, y + j)) {
									continue;
								}
								if (map[x + i][y + j] == 1) {
									count++;
								}
							}
						}
						// 운영 비용 = K*K+(K-1)*(K-1)
						int c = count * M - cost[k];
						if (0 <= c) {
							answer = Math.max(answer, count);
						}
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}

	}

	private static void print(int[][] check) {
		System.out.println("==================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==================");
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}
