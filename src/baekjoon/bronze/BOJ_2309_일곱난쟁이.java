package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

//백준_일곱난쟁이_2309_브론즈2
public class BOJ_2309_일곱난쟁이 {
	static int[] height;
	static boolean[] selected;
	static boolean finished;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		height = new int[9];
		selected = new boolean[9];

		for (int i = 0; i < 9; i++) {
			height[i] = scan.nextInt();
		}
		Arrays.sort(height);
		finished=false;
		nCr(0, 0);
	}

	public static void nCr(int cnt, int start) {
		if(finished) {
			return;
		}
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (selected[i]) {
					sum+=height[i];
				}
			}
			if(sum==100) {
				for (int i = 0; i < 9; i++) {
					if (selected[i]) {
						System.out.println(height[i]);
					}
				}
				finished = true;
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			selected[i] = true;
			nCr(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

}
