package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10039_평균점수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int score = Integer.parseInt(br.readLine());
			// 40점 미만이면 보충수업으로 40점을 받음
			sum += score < 40 ? 40 : score;
		}
		System.out.println(sum / 5);
	}
}
