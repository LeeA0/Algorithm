package baekjoon.silver;

import java.util.Scanner;
import java.util.TreeSet;

//백준_단어정렬_1181_실버5
public class BOJ_1181_단어정렬 {
	static class Word implements Comparable<Word> {
		String word;

		public Word(String word) {
			super();
			this.word = word;
		}

		@Override
		public int compareTo(Word o) {
			if (this.word.length() > o.word.length()) {
				return 1;
			} else if (this.word.length() < o.word.length()) {
				return -1;
			}
			return this.word.compareTo(o.word);
		}
	}

	static int N;
	static TreeSet<Word> treeset;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		treeset = new TreeSet<Word>();
		for (int i = 0; i < N; i++) {
			treeset.add(new Word(scan.next()));
		}

		for (Word w : treeset) {
			System.out.println(w.word);
		}
	}
}
