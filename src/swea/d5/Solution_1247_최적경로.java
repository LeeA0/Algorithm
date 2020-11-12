package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//SW_최적경로_1247_D5
public class Solution_1247_최적경로 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int T, N, min;
	static Point company, home;
	static ArrayList<Point> customer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());

			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customer = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				customer.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			min = Integer.MAX_VALUE;
			nPr(0, 0, new ArrayList<Point>());
			System.out.println("#" + t + " " + min);
		}
	}

	private static void nPr(int cnt, int flag, ArrayList<Point> list) {
		if (cnt == N) {
			int dist = getdist(company, list.get(0));
			for (int i = 0; i < N - 1; i++) {
				dist += getdist(list.get(i), list.get(i + 1));
			}
			dist += getdist(list.get(N - 1), home);
			min = Math.min(min, dist);
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}
			list.add(customer.get(i));
			nPr(cnt + 1, (flag | (1 << i)), list);
			list.remove(customer.get(i));
		}

	}

	public static int getdist(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}
