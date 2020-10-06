package baekjoon.silver;

// SW7393 -> 백준 1562
import java.util.Scanner;

//백준_1로 만들기_1463_실버3
public class BOJ_1463_1로만들기 {
	static int N;
	static int[] cnt;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		cnt = new int[N + 1];
		int min;
		for (int i = 2; i < N + 1; i++) {
			min = Integer.MAX_VALUE;
			if (i % 3 == 0 && min > cnt[i / 3]) {
				min = cnt[i / 3] + 1;
			} 
			if (i % 2 == 0 && min > cnt[i / 2]) {
				min = cnt[i / 2] + 1;
			} 
			if (min > cnt[i - 1]) {
				min = cnt[i - 1] + 1;
			}
			cnt[i] = min;
		}
		System.out.println(cnt[N]);
	}
}
