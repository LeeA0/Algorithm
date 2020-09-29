package baekjoon.bronze;

import java.util.Scanner;

//백준_알람시계_2884_브론즈3
public class BOJ_2884_알람시계 {
	static int H, M;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		H = scan.nextInt();
		M = scan.nextInt();

		if (M >= 45) {
			M -= 45;
		} else {
			M += 60 - 45;
			if (H == 0) {
				H = 24 - 1;
			} else {
				H--;
			}
		}
		System.out.println(H+" "+M);
	}
}
