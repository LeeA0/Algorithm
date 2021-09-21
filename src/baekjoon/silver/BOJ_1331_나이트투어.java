package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_1331_나이트투어_실버5
public class BOJ_1331_나이트투어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] isVisited = new boolean[6][6];
		boolean flag = true;

		// 시작점으로 돌아왔는지 확인하기 위해 시작점 저장
		String coordinate = br.readLine();
		int sx = coordinate.charAt(0) - 'A';
		int sy = coordinate.charAt(1) - '1';
		
		int x = sx;
		int y = sy;
		for (int i = 1; i < 36; i++) {
			coordinate = br.readLine();
			int nx = coordinate.charAt(0) - 'A';
			int ny = coordinate.charAt(1) - '1';
			if (isVisited[nx][ny] || !isNight(x, y, nx, ny)) {
				flag = false;
				break;
			}
			isVisited[nx][ny] = true;
			x = nx;
			y = ny;
		}
		if (!isNight(x, y, sx, sy)) {
			flag = false;
		}
		System.out.println(flag ? "Valid" : "Invalid");
	}

	public static boolean isNight(int x, int y, int nx, int ny) {
		int diffX = Math.abs(x - nx);
		int diffY = Math.abs(y - ny);
		return (diffX == 2 && diffY == 1) || (diffX == 1 && diffY == 2);
	}
}
