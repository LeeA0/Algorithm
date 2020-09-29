package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

//백준_단어공부_1157_브론즈1
public class BOJ_1157_단어공부 {
	static char[] word;
	static int[] num;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		word = scan.next().toUpperCase().toCharArray();
		num = new int[26];
		for (int i = 0; i < word.length; i++) {
			num[word[i] - 'A']++;
		}
		int max = 0;
		int idx = 0;

		for (int i = 0; i < 26; i++) {
			if (max < num[i]) {
				max = num[i];
				idx = i;
			}
		}

		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (num[i] == max) {
				cnt++;
			}
		}
		System.out.println(cnt>1?"?":(char)(idx+'A'));

	}

}
