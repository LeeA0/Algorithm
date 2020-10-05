package baekjoon.silver;
import java.util.Scanner;

//백준_부분수열의 합_1182_실버2
public class BOJ_1182_부분수열의합_Subset {
	static int N, S, count;
	static int[] array;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = scan.nextInt();
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = scan.nextInt();
		}
		isSelected = new boolean[N];
		count = 0;
		Subset(0, 0);
		System.out.println(count);
	}

	private static void Subset(int cnt, int sum) {
		if (N == cnt) {
			boolean notfalse = false;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					notfalse = true;
				}
			}
			if (notfalse && sum == S) {
				count++;
			}
			return;
		}
		isSelected[cnt] = true;
		Subset(cnt + 1, sum + array[cnt]);
		isSelected[cnt] = false;
		Subset(cnt + 1, sum);
	}
}
