package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_수열_2559_실버3
public class BOJ_2559_수열 {
	static int N, K, max;
	static int[] temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		max = Integer.MIN_VALUE;

		temp = new int[N];
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		
		for (int i = 0; i < N; i++) {
			temp[i]=Integer.parseInt(st.nextToken());
		}
		//0~N-K개가 처음부분
		for (int i = 0; i <= N - K; i++) {
			int sum = 0;
			//처음부분 포함 K개만큼 더한다
			for (int j = 0; j < K; j++) {
				sum += temp[i + j];
			}
			//비교한다
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
