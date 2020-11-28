package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//SW_음식배달_10888_D4
public class Solution_10888_음식배달 {
	static int T, N, min_answer;
	static int[][] map;
	static LinkedList<int[]> food, home;
	static boolean[] foodSelect;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			food = new LinkedList<int[]>();
			home = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						home.add(new int[] { i, j });
					}
					if (map[i][j] >= 2) {
						food.add(new int[] { i, j });
					}
				}
			}
			foodSelect = new boolean[food.size()];
			min_answer = Integer.MAX_VALUE;
			subset(0);
			System.out.println("#" + t + " " + min_answer);
		}
	}

	public static void subset(int cnt) {
		if (cnt == food.size()) {
			int cost = 0;
			
			//배달거리 더하기
			for (int j = 0; j < home.size(); j++) {
				int home_x = home.get(j)[0];
				int home_y = home.get(j)[1];
				int min_dist = Integer.MAX_VALUE;
				for (int i = 0; i < food.size(); i++) {
					if (foodSelect[i]) {
						int food_x = food.get(i)[0];
						int food_y = food.get(i)[1];
						int dist = (Math.abs(food_x - home_x) + Math.abs(food_y - home_y));
						min_dist = Math.min(min_dist,dist);
					}
				}
				cost += min_dist;
			}
			
			// 음식점 운영비용 더하기
			for (int i = 0; i < food.size(); i++) {
				if (foodSelect[i]) {
					int food_x = food.get(i)[0];
					int food_y = food.get(i)[1];
					cost += map[food_x][food_y];
				}
			}
			
			if (cost > 0) {
				min_answer = Math.min(min_answer, cost);
			}
			return;
		}
		// 해당 치킨 집을 선택
		foodSelect[cnt] = true;
		subset(cnt + 1);
		// 해당 치킨집을 선택 하지 않음
		foodSelect[cnt] = false;
		subset(cnt + 1);
	}
}
