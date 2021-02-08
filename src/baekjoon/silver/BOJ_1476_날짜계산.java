package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_날짜계산_1476_실버5
public class BOJ_1476_날짜계산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken()) - 1;
		int s = Integer.parseInt(st.nextToken()) - 1;
		int m = Integer.parseInt(st.nextToken()) - 1;
		final int E = 15;
		final int S = 28;
		final int M = 19;

		// e를 시작으로 15씩 더해가며
		for (int i = e; i < 7981; i += E) {
			// 그 숫자를 28로 나머지 연산을 했을 떄의 값이 s와 같고
			// 그 숫자를 19로 나머지 연산을 했을 때의 값이 m과 같으면 정답
			if (i % S == s && i % M == m) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
