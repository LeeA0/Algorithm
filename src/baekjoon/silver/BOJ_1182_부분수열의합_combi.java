package baekjoon.silver;
import java.util.Scanner;

//백준_부분수열의 합_1182_실버2
public class BOJ_1182_부분수열의합_combi {
	static int N, R, S, count;
	static int[] array;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = scan.nextInt();
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = scan.nextInt();
		}
		count = 0;
		for (int i = 1; i <= N; i++) {
			R = i;
			nCr(0, 0, 0);
		}
		System.out.println(count);
	}

	private static void nCr(int cnt, int start, int sum) {
		if (R == cnt) {
			if (sum == S) {
				count++;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			nCr(cnt + 1, i + 1, sum + array[i]);
		}
	}
}
