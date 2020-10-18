package baekjoon.silver;

import java.util.Scanner;

//백준_도영이가만든맛있는음식_2961_실버1
public class BOJ_2961_도영이가만든맛있는음식 {
	static int N, min;
	static int[] S, B;// 신맛, 쓴맛
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			S[i] = scan.nextInt();
			B[i] = scan.nextInt();
		}
		isSelected = new boolean[N];
		min=Integer.MAX_VALUE;
		subset(0);
		System.out.println(min);
	}

	private static void subset(int cnt) {
		if (N == cnt) {
			int s_sum = 1;
			int b_sum = 0;
			boolean e = false;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					s_sum *= S[i];
					b_sum += B[i];
					e = true;
				}
			}
			if (e) {
				min = Math.min(min, Math.abs(b_sum - s_sum));
			}
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1); // 포함
		isSelected[cnt] = false;
		subset(cnt + 1); // 안포함
	}
}