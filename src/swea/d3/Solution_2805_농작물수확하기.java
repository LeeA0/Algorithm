package swea.d3;

import java.util.Scanner;

//SW_농작물수확하기_2805_D3
public class Solution_2805_농작물수확하기 {
	static int T, N, answer;
	static int[][] farm;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] farm_c = scan.next().toCharArray();
				for (int j = 0; j < N; j++) {
					farm[i][j] = farm_c[j] - 48;
				}
			}

			// 중심으로 부터 이동가능 회수
			answer = 0;
			int middle = N / 2;
			int x = 0, y = middle;
			for (int i = 0; i < middle; i++) {
				y = middle;
				answer += farm[x][y];
				System.out.println(farm[x][y]);
				answer += farm[(N - 1) - x][y];
				System.out.println(farm[(N - 1) - x][y]);
				// 좌
				for (int j = 0; j < x; j++) {
					y -= 1;
					answer += farm[x][y];
					System.out.println(farm[x][y]);
					answer += farm[(N - 1) - x][y];
					System.out.println(farm[(N - 1) - x][y]);
				}
				// 우
				y = middle;
				for (int j = 0; j < x; j++) {
					y += 1;
					answer += farm[x][y];
					System.out.println(farm[x][y]);
					answer += farm[(N - 1) - x][y];
					System.out.println(farm[(N - 1) - x][y]);
				}
				x+=1;
			}
			// 정가운데
			answer += farm[middle][middle];
			System.out.println(farm[middle][middle]);
			// 가운데 줄 좌
			for (int j = 0; j < middle; j++) {
				y -= 1;
				answer += farm[x][y];
				System.out.println(farm[x][y]);
			}
			// 가운데 줄 우
			y = N / 2;
			for (int j = 0; j < middle; j++) {
				y += 1;
				answer += farm[x][y];
				System.out.println(farm[x][y]);
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
