package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_한빈이와 Spot Mart_9229_D3
public class Solution_9229_한빈이와SpotMart {
	static int T, N, M;
	static int[] weight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			weight = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			int sum = 0, max_sum = -1;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					sum = weight[i] + weight[j];
					if (max_sum < sum && M >= sum) {
						max_sum = sum;
					}
				}
			}
			System.out.println("#" + t + " " + max_sum);
		}
	}
}
