package basic.nPr;

import java.util.Arrays;

public class Perm4_swap {
	static int R = 2, N = 4;
	static int[] arr = { 1, 2, 3, 4 };
	static int[] perms = new int[R];
	public static void main(String[] args) {
		perm(0);
	}
	static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(perms));
			return;
		}
		for (int i = cnt; i < N; i++) {
			perms[cnt] = arr[i];
			swap(cnt, i);
			perm(cnt + 1);
			swap(cnt, i);
		}
	}

	static void swap(int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
