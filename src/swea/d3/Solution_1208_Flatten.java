package swea.d3;

import java.util.Scanner;

//SW_Flatten_1208_D3
public class Solution_1208_Flatten {
	static int T = 10, N = 100, dumpN, answer;
	static int[] wall;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			dumpN = scan.nextInt();
			wall = new int[N];
			for (int i = 0; i < wall.length; i++) {
				wall[i] = scan.nextInt();
			}
			// 덤핑
			answer = dump();

			System.out.println("#" + t + " " + answer);
		}
	}

	private static int dump() {
		int max_i = 0, min_i = 0;
		for (int i = 0; i < dumpN; i++) {
			for (int j = 0; j < wall.length; j++) {
				if (wall[max_i] < wall[j])
					max_i = j;
				if (wall[min_i] > wall[j])
					min_i = j;
			}
			wall[max_i]--;
			wall[min_i]++;
			if(wall[max_i]-wall[min_i]<=1) {
				break;
			}
		}
		for (int j = 0; j < wall.length; j++) {
			if (wall[max_i] < wall[j])
				max_i = j;
			if (wall[min_i] > wall[j])
				min_i = j;
		}

		return wall[max_i] - wall[min_i];
	}

}
