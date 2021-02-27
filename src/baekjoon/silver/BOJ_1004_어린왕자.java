package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_어린왕자_1004_실버3
public class BOJ_1004_어린왕자 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 시작점 좌표
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			// 끝점 좌표
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			// 행성의 개수
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				// 행성의 중점과 반지름
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				// 시작점혹은 끝점을 하나만 포함하고 있는 경우 진입/이탈이 발생하게된다
				// 따라서, 행성 내부에 시작점과 끝점 중 둘 중 하나만 포함하고 있는 행성이면
				if (include(sx, sy, x, y, r)^include(ex, ey, x, y, r)) {
					// 진입/이탈 횟수를 증가시킨다
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}

	// gx, gy: 시작점 혹은 끝점의 좌표  
	// x, y: 행성의 중점
	// r: 행성의 반지름
	static boolean include(int gx, int gy, int x, int y, int r) {
		// 원의 방정식 (x-a)^2+(y-b)^2<r^2을 만족하면 점이 행성의 내부에 있다라고 판단 할 수 있다
		return Math.pow(gx - x, 2) + Math.pow(gy - y, 2) < Math.pow(r, 2);
	}
}
