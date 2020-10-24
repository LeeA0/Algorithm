package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_한빈이와 Spot Mart_9229_D3
//포문에 비해 실행속도 빠름. 메모리 적음.
public class Solution_9229_한빈이와SpotMart_using_combi {
	static int T, N, M, max;
	static int[] weight, select;

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
			max = -1;
			select = new int[2];
			nCr(0, 0);
			System.out.println("#" + t + " " + max);
		}
	}

	private static void nCr(int cnt, int start) {
		if (cnt == 2) {
			int sum = select[0] + select[1];
			if (max < sum && sum <= M) {
				max = sum;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			select[cnt] = weight[i];
			nCr(cnt + 1, i + 1);
		}
	}
}
