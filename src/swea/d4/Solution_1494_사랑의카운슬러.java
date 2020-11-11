package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 만약 N=4라면
 * 1100  0011
 * 1010  0101
 * 1001  0110
 * 이동하는 지렁이와 이동하지않는 지렁이 그룹의 멤버가 같다.
 * 아무 의미가 없으므로 절반으로 잘라준 것.
 */

//SW_사랑의 카운슬러_1494_D4
public class Solution_1494_사랑의카운슬러 {
	static class Worm {
		int x;
		int y;

		public Worm(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int T, N;
	static long min;
	static ArrayList<Worm> worms;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			worms = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				worms.add(new Worm(x, y));
			}
			min = Long.MAX_VALUE;
			nCr(0, 0, new boolean[N]);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void nCr(int cnt, int start, boolean[] list) {
		if (cnt == N / 2) {
			// 가만히 있는 지렁이의 합 - 움직이는 지렁이의 합 = 벡터
			Worm aWormSum = new Worm(0, 0);
			Worm bWormSum = new Worm(0, 0);
			for (int i = 0; i < N; i++) {
				// true인 지렁이가 A->B 중 A
				if (list[i]) {
					aWormSum.x += worms.get(i).x;
					aWormSum.y += worms.get(i).y;
				} else {
					bWormSum.x += worms.get(i).x;
					bWormSum.y += worms.get(i).y;
				}
			}
			// 벡터 V = (x,y)
			long vectorX = bWormSum.x - aWormSum.x;
			long vectorY = bWormSum.y - aWormSum.y;

			// |V| = |(x,y)| = x * x + y * y
			long vectorSum = vectorX * vectorX + vectorY * vectorY;

			min = Math.min(min, vectorSum);
			return;
		}
		for (int i = start; i < N; i++) {
			list[i] = true;
			nCr(cnt + 1, i + 1, list);
			// 위에 참조
			if (cnt == 0) {
				return;
			}
			list[i] = false;
		}
	}
}