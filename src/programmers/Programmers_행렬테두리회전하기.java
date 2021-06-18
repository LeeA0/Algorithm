package programmers;

import java.util.Arrays;

// Programmers_행렬테두리회전하기_level2
public class Programmers_행렬테두리회전하기 {
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[][] arr = new int[rows][columns];
		int cnt = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = cnt++;
			}
		}

		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			answer[i] = rotation(arr, queries[i]);
		}
		return answer;
	}

	public static int rotation(int[][] arr, int[] query) {
		int[][] dir4 = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		int sx = query[0] - 1;
		int ex = query[2] - 1;
		int sy = query[1] - 1;
		int ey = query[3] - 1;

		int nx = sx;
		int ny = sy;
		int temp = arr[nx][ny];
		int d = 0;
		int min = temp;
		for (int i = 0; i < 4; i++) {
			while (true) {
				nx += dir4[d][0];
				ny += dir4[d][1];
				if (sx > nx || nx > ex || sy > ny || ny > ey) {
					nx -= dir4[d][0];
					ny -= dir4[d][1];
					break;
				}
				int pre = arr[nx][ny];
				min = Math.min(min, pre);
				arr[nx][ny] = temp;
				temp = pre;
			}
			d++;
		}

		return min;
	}
}
