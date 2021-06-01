package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1145_적어도대부분의배수_브론즈1
public class BOJ_1145_적어도대부분의배수 {
	static int answer;
	static int[] number;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		number = new int[5];

		for (int i = 0; i < 5; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료

		// 적어도 3개로 나누어지는 가장 작은 자연수이기 때문에 최대값으로 초기화
		answer = Integer.MAX_VALUE;
		// 3개를 뽑는다
		nCr(0, 0, new int[3]);

		System.out.println(answer);
	}

	public static void nCr(int start, int cnt, int[] select) {
		// 3개를 다 뽑았으면
		if (cnt == 3) {
			// 3개의 최소공배수를 구한다 (feat. 유클리드 호제법)
			int lcm = select[0];
			for (int i = 1; i < 3; i++) {
				lcm = (lcm*select[i])/gcd(lcm,select[i]);
			}
			// answer과 비교해서 작은 값을 저장한다
			answer = Math.min(answer, lcm);
			return;
		}
		// 5개 중에서 한 개를 뽑는다
		for (int i = start; i < 5; i++) {
			select[cnt] = number[i];
			nCr(i + 1, cnt + 1, select);
		}
	}

	public static int gcd(int a, int b) {
		// a가 큰 값, b가 작은 값으로 만들기 위해서 a보다 b가 크면 바꿔준다
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		// 최대공약수를 찾는다
		while (a % b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return b;
	}
}
