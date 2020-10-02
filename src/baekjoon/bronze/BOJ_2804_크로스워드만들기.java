package baekjoon.bronze;

import java.util.Scanner;
//백준_크로스워드만들기_2804_브론즈2
public class BOJ_2804_크로스워드만들기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] a = scan.next().toCharArray();
		char[] b = scan.next().toCharArray();
		char[][] crossword = new char[b.length][a.length];

		int ai = 0;
		int bi = 0;
		
		//초기화 
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < a.length; j++) {
				crossword[i][j] = '.';
			}
		}
		
		a: for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					ai = i;
					bi = j;
					break a;
				}
			}
		}
		crossword[bi] = a;
		for (int i = 0; i < b.length; i++) {
			crossword[i][ai] = b[i];
		}
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(crossword[i][j]);
			}
			System.out.println();
		}
	}
}
