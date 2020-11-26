package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// nCr+Subset
// SW_벌꿀채취_2115
public class Solution_2115_벌꿀채취 {
	static int T, N, M, C, answer;
	static int[][] honey_map;
	static LinkedList<int[]> honey;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			honey_map = new int[N][N];
			honey = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					honey_map[i][j] = Integer.parseInt(st.nextToken());
					honey.add(new int[] { i, j });
				}
			}

			answer = 0;

			nCr(0, 0, new int[N][N]);

			System.out.println("#" + t + " " + answer);
		}
	}

	private static void nCr(int cnt, int start, int[][] isSelected) {
		if (cnt == 2) {
			LinkedList<Integer> honey1 = new LinkedList<Integer>();
			LinkedList<Integer> honey2 = new LinkedList<Integer>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isSelected[i][j] == 1) {
						honey1.add(honey_map[i][j]);
					}
					if (isSelected[i][j] == 2) {
						honey2.add(honey_map[i][j]);
					}
				}
			}

			int psum1 = subset(honey1);
			int psum2 = subset(honey2);

			answer = Math.max(answer, psum1 + psum2);

			return;
		}
		for (int i = start; i < honey.size(); i++) {
			int[] curr = honey.get(i);

			int nx = curr[0];
			int ny = curr[1];
			// 앞으로 선택할 곳이 영역을 벗어날 예정이거나 이미 선택 했던 곳일 때 건너뛴다
			if (ny > N - M || isSelected[nx][ny] != 0)
				continue;

			// 벌꿀 통 선택
			for (int m = 0; m < M; m++) {
				isSelected[nx][ny] = cnt + 1;
				ny += 1;
			}
			nCr(cnt + 1, i + 1, isSelected);

			// 벌꿀 통 선택 해제
			nx = curr[0];
			ny = curr[1];
			for (int m = 0; m < M; m++) {
				isSelected[nx][ny] = 0;
				ny += 1;
			}
		}
	}

	private static int subset(LinkedList<Integer> honeylist) {
		int max_psum = 0;

		// 공집합을 빼고 돌림
		for (int i = 1; i < 1 << M; i++) {
			int sum = 0;
			int psum = 0;
			// flag의 각 비트자리를 확인하여 원소 선택 유/무를 판단
			for (int j = 0; j < M; j++) {
				if ((i & (1 << j)) != 0) {// 어떤비트든 한비트가 1임 (==1은 안됨)
					sum += honeylist.get(j);
					psum += honeylist.get(j) * honeylist.get(j);
				}
			}
			if (sum <= C && psum > max_psum) {
				max_psum = psum;
			}
		}

		return max_psum;
	}
}
