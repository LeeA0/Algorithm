package swea.d3;

import java.util.Scanner;

//SW_원재의 메모리 복구하기_1289_D3
public class Solution_1289_원재의메모리복구하기 {
	static int T;
	static String memory;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();

		for (int t = 1; t <= T; t++) {
			memory = scan.next();
			char c = '0'; // 기준문자
			int count = 0;
			for (int i = 0; i < memory.length(); i++) {
				if (memory.charAt(i) != c) {
					count++;
					if (c == '0') {
						c = '1';
					} else {
						c = '0';
					}
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}
