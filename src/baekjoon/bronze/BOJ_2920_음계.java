package baekjoon.bronze;

import java.util.Scanner;

//백준_음계_2920_브론즈2
public class BOJ_2920_음계 {
	static int[] music;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		music = new int[8];
		for (int i = 0; i < 8; i++) {
			music[i] = scan.nextInt();
		}

		boolean isAscending = true, isDescending = true;
		// ascending
		for (int i = 1; i <= 8; i++) {
			if (i != music[i-1]) {
				isAscending = false;
				break;
			}
		}
		if (!isAscending) {
			// descending
			for (int i = 1; i <= 8; i++) {
				if (i != music[8-i]) {
					isDescending = false;
					break;
				}
			}
			if(!isDescending) {
				System.out.println("mixed");
			}else {
				System.out.println("descending");
			}
		}else {
			System.out.println("ascending");
		}
	}
}
