package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//SW_준환이의 양팔저울_3234_D4_using swap nPr
public class Solution_3234_준환이의양팔저울 {
	static int T, N, count;
	static int[] weight;
	static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			weight = new int[N];
			num = new int[N];
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			count = 0;
			nPr(0);
			System.out.println("#" + t + " " + count);
		}
	}

	public static void nPr(int cnt) {
		if (cnt == N) {
			getCount(0, 0, 0);
			return;
		}
		for (int i = cnt; i < N; i++) {
			num[cnt] = weight[i];
			swap(cnt, i);
			nPr(cnt + 1);
			swap(cnt, i);
		}
	}

	public static void swap(int cnt, int i) {
		int temp = weight[cnt];
		weight[cnt] = weight[i];
		weight[i] = temp;
		return;
	}

	public static void getCount(int lw, int rw, int n) {
		if (lw < rw) {
			return;
		}
		if (n == N) {
			count++;
			return;
		}
		getCount(lw + num[n], rw, n + 1);
		getCount(lw, rw + num[n], n + 1);
	}
}
