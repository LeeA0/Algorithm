package baekjoon.silver;
import java.util.Scanner;

//백준_모든 순열_10974_실버3
public class BOJ_10974_모든순열 {
	static int N;
	static int[] num;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		num = new int[N];
		isSelected = new boolean[N];
		nPr(0);
	}
	private static void nPr(int cnt) {
		if(N==cnt) {
			for (int n : num) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			num[cnt] = i+1;
			nPr(cnt+1);
			isSelected[i] = false;
		}
	}
}
