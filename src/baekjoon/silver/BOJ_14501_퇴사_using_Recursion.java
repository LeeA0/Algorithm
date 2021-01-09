package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_퇴사_14501_실버4
public class BOJ_14501_퇴사_using_Recursion {
	// N: 퇴사하기 까지의 날짜, max_money: 최대 수익
	static int N, max_money;
	// counsel: 상담소요 일수와 수익
	static int[][] counsel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		// 상담소요 일수와 수익을 한번에 받기 위해 2차원 배열 선언
		counsel = new int[N][2];
		for (int i = 0; i < N; i++) {
			// 공백으로 나뉘어져 있으므로 StringTokenizer를 이용해 분리 후 넣어줌
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		} // 입력완료

		// 첫 시작은 0일, 수익 0
		pick(0, 0);

		// 최대 수익을 출력한다
		System.out.println(max_money);
	}

	// day: 현재 날짜
	// sum: 수익의 합
	public static void pick(int day, int sum) {
		// 모든 일정이 끝나면 최대수익과 이때까지 수익을 비교하여 제일 큰 값을 저장 후 리턴 
		if (day >= N) {
			max_money = Math.max(max_money, sum);
			return;
		}
		// 해당 상담을 안 했을 때 다음날로 넘김
		pick(day + 1, sum);
		// (현재 날짜 + 상담소요 일수)가 퇴사일을 넘어가면 상담을 할 수 없으므로 합이 N과 작거나 같을 때 상담 가능
		// *마지막날 1일짜리 상담을 할 수 있으므로 N일 때를 고려해야한다
		if (day + counsel[day][0] <= N) {
			// 해당 상담을 했을 때
			pick(day + counsel[day][0], sum + counsel[day][1]);
		}
	}
}
