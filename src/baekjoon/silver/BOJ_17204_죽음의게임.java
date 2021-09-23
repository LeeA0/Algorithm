package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_17204_죽음의게임_실버3
public class BOJ_17204_죽음의게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] pointer = new int[N];
		for (int i = 0; i < N; i++) {
			pointer[i] = Integer.parseInt(br.readLine());
		}

		int idx = pointer[0];
		// 인원 수 만큼 지목했는데 K번이 지목되지 않았다면, 앞으로도 K번이 걸리지 않음
		for (int i = 1; i <= N; i++) {
			if (idx == K) {
				System.out.println(i);
				return;
			}
			idx = pointer[idx];
		}
		System.out.println(-1);
	}
}