package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준_치킨배달_15686_골드5
public class BOJ_15686_치킨배달 {
	static int N, M, answer;
	static int[][] map;
	static ArrayList<int[]> chicken, house;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new ArrayList<int[]>();
		house = new ArrayList<int[]>();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				} else if (map[i][j] == 1) {
					house.add(new int[] { i, j });
				}
			}
		}
		answer=Integer.MAX_VALUE;
		nCr(0, 0, new ArrayList<String>());
		System.out.println(answer);
	}

	private static void nCr(int cnt, int start, ArrayList<String> list) {
		if (cnt == M) {
			// 선택된 치킨집의 거리 구하기
			int dist = 0;
			for (int[] ho : house) {
				int min = Integer.MAX_VALUE;
				for (String i : list) {
					int[] chi = chicken.get(Integer.parseInt(i));
					min = Math.min(min, Math.abs(chi[0] - ho[0]) + Math.abs(chi[1] - ho[1]));
				}
				dist+=min;
			}
			answer=Math.min(answer, dist);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			list.add((i) + "");
			nCr(cnt + 1, i + 1, list);
			list.remove((i) + "");
		}
	}
}
