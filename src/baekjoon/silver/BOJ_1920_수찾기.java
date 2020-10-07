package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준_수 찾기_1920_실버4
public class BOJ_1920_수찾기 {
	static int N, M;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		M = Integer.parseInt(br.readLine().trim());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(st.nextToken());
			boolean ok = search(m);
			sb.append(ok ? 1 : 0).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean search(int m) {
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == m) {
				return true;
			} else if (A[mid] > m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}
}