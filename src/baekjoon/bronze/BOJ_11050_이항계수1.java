package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_이항계수1_브론즈1
public class BOJ_11050_이항계수1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N과 K가 공백을 기준으로 나누어져 있으므로 StringTokenizer를 통해 이를 나눠준다.
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// factorial값을 저장할 배열의 크기를 정하기위해 N과 K 중 숫자가 큰 것을 max에 저장하고, 0번부터 배열이 시작하므로 + 1을 해준다.
		int max = Math.max(N, K) + 1;
		int[] factorial = new int[max];
		// 0팩토리얼의 값은 1이다
		factorial[0] = 1;
		// max-1까지 팩토리얼 값을 구해준다
		for (int i = 1; i < max; i++) {
			factorial[i] = factorial[i-1]*i;
		}
		// 이항계수를 계산한다.
		System.out.println(factorial[N]/(factorial[K]*factorial[N-K]));
	}
}
