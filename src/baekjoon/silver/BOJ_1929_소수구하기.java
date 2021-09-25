package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1929_소수구하기_실버2
public class BOJ_1929_소수구하기 {
	static boolean[] numbers;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		if (M == 1) {
			M++;
		}
		numbers = new boolean[N - M + 1];
		findPrime();

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!numbers[i - M]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void findPrime() {
		// 에라토스테네스의 체를 이용
		for (int i = 2; i <= Math.sqrt(N); i++) {
			int j = findNumberIdxOverM(i);
			deleteMultiple(i,j);
		}
	}

	public static void deleteMultiple(int multiple, int factor) {
		while (true) {
			int num = factor * multiple;
			if (num > N) {
				break;
			}
			if (multiple != num) {
				numbers[num - M] = true;
			}
			factor++;
		}
	}

	public static int findNumberIdxOverM(int i) {
		return (int) Math.ceil((double) M / (double) i);
	}
}
