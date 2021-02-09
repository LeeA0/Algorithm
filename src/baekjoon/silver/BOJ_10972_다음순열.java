package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_다음순열_10972_실버3
public class BOJ_10972_다음순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		if (nextPermutation(N, array)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(array[i]).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	static boolean nextPermutation(int N, int[] array) {
		// 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;

		// 이미 내림차순 정렬이면
		if (i == 0) {
			return false;
		}

		// i-1과 교환할 다음 큰 수 찾기
		int j = N - 1;
		while (array[i - 1] >= array[j])
			j--;

		// i-1과 j 교환
		swap(array, i - 1, j);

		// i-1뒤쪽(i부터)에 있는 원소를 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(array, i++, k--);
		}

		return true;
	}

	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
