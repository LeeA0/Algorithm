package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간 더 줄여보기 -> nCr이용
//백준_꽃길_14620_실버2
public class BOJ_14620_꽃길 {
	static int N, answer;
	static int[][] price;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		price = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MAX_VALUE;

		// 어처피 모서리는 심지 못한다.
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				plant(0, 0, i, j, new boolean[N][N]);
			}
		}

		System.out.println(answer);
	}

	private static void plant(int cnt, int sum, int x, int y, boolean[][] flower) {
		//가치치기
		//sum이 answer보다 크거나 같으면 return
		if(sum>=answer) {
			return;
		}
		
		if (cnt == 3) {
			answer = Math.min(answer, sum);
			return;
		}

		// 꽃을 심는다
		flower[x][y] = true;
		sum += price[x][y];

		// 꽃잎 표시
		for (int[] d : dir4) {
			int nx = x + d[0];
			int ny = y + d[1];
			// 꽃잎이 경계밖을 벗어나거나 다른 꽃과 겹치면 심을 수 없다
			// -> return
			if (!check(nx, ny) || flower[nx][ny]) {
				return;
			}
			flower[nx][ny] = true;
			sum += price[nx][ny];
		}

		// 다른 곳에 꽃을 심는다.
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (!flower[i][j]) {
					boolean[][] new_flower = copy(flower);
					plant(cnt + 1, sum, i, j, new_flower);
				}
			}
		}
	}

	private static boolean[][] copy(boolean[][] flower) {
		boolean[][] new_flower = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				new_flower[i][j]=flower[i][j];
			}
		}
		
		return new_flower;
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}