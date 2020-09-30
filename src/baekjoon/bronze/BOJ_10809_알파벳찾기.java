package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

//백준_알파벳찾기_10809_브론즈2
public class BOJ_10809_알파벳찾기 {
	static char[] S;
	static int[] alphabet;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		S = scan.next().toCharArray();
		alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		for (int i = 0; i < S.length; i++) {
			int index = S[i]-'a';
			if (alphabet[index] == -1) {
				alphabet[index] = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(alphabet[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
