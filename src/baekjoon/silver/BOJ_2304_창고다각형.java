package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준_창고다각형_2304_실버2
public class BOJ_2304_창고다각형 {
	static int N, sum, max;
	static LinkedList<int[]> col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		col = new LinkedList<int[]>();

		// 기둥들 중 최대 높이
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int index = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			col.add(new int[] { index, height });
			max = Math.max(max, height);
		}
		// 위치순으로 내림차순 정렬
		Collections.sort(col, (o1, o2) -> (o1[0] - o2[0]));

		sum = 0;
		int start_index = 0;
		int end_index = N - 1;
		// 가로방향으로 넓이구하기
		int h = 1;
		while (h <= max) {
			// 만약 현재 시작기둥의 높이가 h보다 낮을 때 시작기둥을 다음 기둥으로 옮겨준다.
			if (col.get(start_index)[1] < h) {
				start_index++;
				continue;
			}
			// 만약 현재 종료기둥의 높이가 h보다 낮을 때 종료기둥을 다음(이전) 기둥으로 옮겨준다.
			if (col.get(end_index)[1] < h) {
				end_index--;
				continue;
			}
			sum += col.get(end_index)[0] + 1 - col.get(start_index)[0];
			h++;
		}
		System.out.println(sum);
	}
}