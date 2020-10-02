package baekjoon.bronze;

import java.util.Scanner;

//백준_방배정_13300_브론즈2
public class BOJ_13300_방배정 {
	static int N, K;
	static int[][] student;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		student = new int[2][6];
		for (int i = 0; i < N; i++) {
			int gender = scan.nextInt();
			int grade = scan.nextInt();
			student[gender][grade - 1]++;
		}
		int room = 0;
		for (int i = 0; i < 6; i++) {
			room += (int) Math.ceil((double)student[0][i] / (double)K);
			room += (int) Math.ceil((double)student[1][i] / (double)K);
		}
		System.out.println(room);
	}
}
