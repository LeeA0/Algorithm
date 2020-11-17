package baekjoon.gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_여행가자_1976_골드4
public class BOJ_1976_여행가자 {
	static int N, M;
	static int[][] map;
	static int[] plan, parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());

		parents = new int[N];
		// make-set
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					union(i, j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		plan = new int[M];
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		boolean cango = true;
		for (int i = 1; i < M; i++) {
			if (find(plan[i] - 1) != find(plan[i - 1] - 1)) {
				cango = false;
			}
		}
		if (cango) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py) {
			return;
		} else {
			parents[py] = px;
		}
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return x;
		} else
			return parents[x] = find(parents[x]);
	}

}
