package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_AB {
	static long A, B, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		answer = Integer.MAX_VALUE;
		AChangeB(A, 1);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	/*
	 * num에 2를 곱하거나 1을 수의 가장 오른쪽에 추가하며 B를 만들 수 있는 지 확인
	 * num이 B를 넘어가면 더 이상 연산할 필요가 없음
	 */
	public static void AChangeB(long num, int changeNum) {
		if (num > B) {
			return;
		}
		if (num == B) {
			answer = Math.min(answer, changeNum);
			return;
		}
		AChangeB(num * 2, changeNum + 1);
		AChangeB(num * 10 + 1, changeNum + 1);
	}
}
