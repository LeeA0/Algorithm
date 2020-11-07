package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준_수정렬하기_2750_실버5
public class BOJ_2750_수정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine().trim());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int a : arr) {
			sb.append(a).append("\n");
		}
		System.out.print(sb);
	}
}
