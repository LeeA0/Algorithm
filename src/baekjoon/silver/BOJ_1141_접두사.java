package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ_1141_접두사_실버3
public class BOJ_1141_접두사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		Arrays.sort(words);
		int max = 0;
		for (int i = 0; i < N - 1; i++) {
			if (!isPrefix(words[i], words[i + 1])) {
				max++;
			}
		}
		System.out.println(max + 1);
	}

	public static boolean isPrefix(String prefix, String word) {
		for (int i = 0; i < prefix.length(); i++) {
			if (prefix.charAt(i) != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
