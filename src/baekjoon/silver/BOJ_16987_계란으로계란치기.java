package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_계란으로계란치기_16987_실버2
public class BOJ_16987_계란으로계란치기 {
	static int N, answer;
	static int[][] egg;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		egg = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}

		answer = 0;

		// 1단계. 가장 왼쪽에 있는 계란을 집어서 꺤다.
		breakEgg(0);

		System.out.println(answer);
	}

	// 현재 들은 계란, 남은 계란의 수
	private static void breakEgg(int curr) {
		if (curr >= N - 1) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (egg[i][0] <= 0) {
					cnt++;
				}
			}
			// 계란이 하나남았거나 모든 달걀을 전부 깬 경우 답을 갱신하고 리턴
			if (cnt == N - 1 || curr == N) {
				answer = Math.max(answer, cnt);
				return;
			}
		}

		// 2단계. 현재 집은 계란이 깨져있지않으면 계란깨기를 수행한다.
		if (egg[curr][0] > 0) {
			for (int i = 0; i < N; i++) {
				// 깨지지않은 다른 계란 중에서 하나를 친다.
				if (i != curr && egg[i][0] >= 0) {
					egg[curr][0] -= egg[i][1];
					egg[i][0] -= egg[curr][1];

					// 3단계. 가장 최근에 든 계란의 한칸 오른쪽 계란을 손에 든다.
					breakEgg(curr + 1);

					egg[curr][0] += egg[i][1];
					egg[i][0] += egg[curr][1];
				}
			}
		}
		// 2단계. 현재 집은 계란이 깨져있으면 다음 계란을 집는다.
		else {
			breakEgg(curr + 1);
		}
	}

}
