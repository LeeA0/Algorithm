package baekjoon.silver;

import java.util.Scanner;

//벡준_색종이_2563_실버5
public class BOJ_2563_색종이 {
	static int N;
	static boolean[][] paper;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		paper = new boolean[101][101];
		
		for (int k = 0; k < N; k++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			for (int i = a; i < a+10; i++) {
				for (int j = b; j < b+10; j++) {
					paper[i][j]=true;
				}
			}
		}
		
		int cnt=0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(paper[i][j]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
