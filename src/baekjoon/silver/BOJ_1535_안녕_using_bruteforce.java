package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1535_안녕_실버2
public class BOJ_1535_안녕_using_bruteforce {
	static int N, maxJoy;
	static int[] L, J;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		L = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		J = new int[N];
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}// 입력

		maxJoy = 0;

		// 인사할 사람을 선택
		selectPeople(0, 0, 100);

		System.out.println(maxJoy);
	}

	public static void selectPeople(int cnt, int sumJoy, int life) {
		// 체력이 0이거나 음수면 죽음
		if (life <= 0) {
			return;
		}
		// 현재까지 기쁨과 최대 기쁨을 비교해 큰 값을 저장
		maxJoy = Math.max(maxJoy, sumJoy);
		// 끝의 사람까지 선택했으면 리턴
		if (cnt == N) {
			return;
		}
		// cnt번째 사람에게 인사 함
		selectPeople(cnt + 1, sumJoy + J[cnt], life - L[cnt]);
		// cnt번째 사람에게 인사 안함
		selectPeople(cnt + 1, sumJoy, life);
	}
}
