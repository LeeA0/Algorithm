package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 백준_버블소트_1377_골드3
public class BOJ_1377_버블소트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1] - o2[1];
		});

		for (int i = 0; i < N; i++) {
			pq.add(new int[] { i, Integer.parseInt(br.readLine())});
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, pq.poll()[0] - i);
		}
		System.out.println(max + 1);
	}
}