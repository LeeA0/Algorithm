package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_2847_게임을만든동준이_실버4

public class BOJ_2847_게임을만든동준이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 게임의 레벨 수
		int N = Integer.parseInt(br.readLine());
		// 레벨에 따른 점수
		int[] number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());
		} // 입력완료
		
		// 점수를 내리는 횟수
		int cnt = 0;
		// 제일 높은 층의 점수
		int maxNum = number[N - 1] - 1;
		// 두번째로 제일 높은 층부터 차례대로 깎아내린다
		// ex) 5 5 5
		// ->  5 4 3 => 0+1+2=3
		for (int i = N - 2; i >= 0; i--) {
			if (maxNum <= number[i]) {
				cnt += number[i] - maxNum;
			} else {
				maxNum = number[i];
			}
			maxNum--;
		}
		System.out.println(cnt);
	}
}
