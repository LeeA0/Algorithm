package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_방향전환_8382_D4
public class Solution_8382_방향전환 {
	static int T, x1, y1, x2, y2, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			answer = Integer.MAX_VALUE;
			move(true);
			move(false);
			
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void move(boolean garo) {
		int x = x1;
		int y = y1;
		int dist = 0;
		while (true) {
			if (x2 == x && y2 == y) {
				answer = Math.min(answer, dist);
				return;
			}

			if (garo) {
				if (x < x2) {
					x += 1;
				} else {
					x -= 1;
				}
			} else {
				if (y < y2) {
					y += 1;
				} else {
					y -= 1;
				}
			}
			dist++;
			garo = !garo;
		}
	}
}
