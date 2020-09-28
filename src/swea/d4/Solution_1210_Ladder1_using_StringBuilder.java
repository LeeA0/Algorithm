package swea.d4;

import java.util.Scanner;

//SW_Ladder1_1210_D4
public class Solution_1210_Ladder1_using_StringBuilder {
	static int T = 10, N = 100;
	//왼,오,위
	static int[][] map,dir3= {{0,-1},{0,1},{-1,0}};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			scan.nextInt();
			//b
			map = new int[N][N];

			int x = 0, y = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}

				}
			}
			while (x != 0) {
				x+=dir3[2][0];
				boolean leftright = false;
				if(y>0) {
					while(y>0&& map[x][y+dir3[0][1]]==1) {
						y+=dir3[0][1];
						leftright = true;
					}
				}
				if(!leftright&&y<99) {
					while(y<99&& map[x][y+dir3[1][1]]==1) {
						y+=dir3[1][1];
					}
				}
			}
			
			StringBuilder sb = new StringBuilder("#");
			sb.append(t).append(" ").append(y);
			System.out.println(sb.toString());
		}

	}

}
