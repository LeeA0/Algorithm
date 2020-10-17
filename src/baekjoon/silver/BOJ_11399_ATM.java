package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

//백준_ATM_11399_실버4
public class BOJ_11399_ATM {
	static int N;
	static int[] time;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		time = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = scan.nextInt();
		}
		Arrays.sort(time);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				sum += time[j];
			}
		}
		System.out.println(sum);
	}
}