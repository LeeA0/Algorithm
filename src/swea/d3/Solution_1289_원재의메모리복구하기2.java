package swea.d3;

import java.util.Scanner;

//SW_원재의메모리복구하기_1289_D3
public class Solution_1289_원재의메모리복구하기2 {
	static int T;
	static int[] memory;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			char[] temp = scan.next().toCharArray();
			int size = temp.length;
			memory = new int[size];
			for (int i = 0; i < size; i++) {
				memory[i] = temp[i] - '0';
			}

			int[] start = new int[size];

			int cnt = 0;
			for (int i = 0; i < size; i++) {
				if (memory[i] != start[i]) {
					cnt++;
					int flag;
					if (start[i] == 0) {
						flag = 1;
					} else {
						flag = 0;
					}
					for (int j = i; j < size; j++) {
						start[j] = flag;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
