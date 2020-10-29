package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_15658_연산자끼워넣기(2)_실버3
public class BOJ_15658_연산자끼워넣기2 {
	static int N, max, min;
	static int[] A, operator, isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		operator = new int[4];
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		isSelected = new int[4];

		nPr(0, A[0]);

		System.out.println(max);
		System.out.println(min);
	}

	public static void nPr(int cnt, int sum) {
		if (cnt == N - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			// 이미 해당 연산자를 고른 횟수가 주어진 수보다 클 때
			if (isSelected[i] == operator[i]) {
				continue;
			}
			isSelected[i]++;
			switch (i) {
			case 0:
				sum += A[cnt + 1];
				break;
			case 1:
				sum -= A[cnt + 1];
				break;
			case 2:
				sum *= A[cnt + 1];
				break;
			case 3:
				if (sum < 0) {
					sum *= -1;
					sum /= A[cnt + 1];
					sum *= -1;
				} else {
					sum /= A[cnt + 1];
					break;
				}
			}
			nPr(cnt + 1, sum);
			switch (i) {
			case 0:
				sum -= A[cnt + 1];
				break;
			case 1:
				sum += A[cnt + 1];
				break;
			case 2:
				sum /= A[cnt + 1];
				break;
			case 3:
				if (sum < 0) {
					sum *= -1;
					sum *= A[cnt + 1];
					sum *= -1;
				} else {
					sum *= A[cnt + 1];
					break;
				}
			}
			isSelected[i]--;
		}
	}
}
