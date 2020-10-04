package baekjoon.silver;

import java.util.Scanner;

//백준_영화감독숌_1436_실버5
public class BOJ_1436_영화감독숌 {
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int cnt = 0;
		for (int i = 666; ; i++) {
			String temp = Integer.toString(i);
			if(temp.contains("666")) {
				cnt++;
				if(cnt==N) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}