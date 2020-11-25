package baekjoon.gold;
import java.util.Scanner;

//백준_집합의 표현_1717_골드4
public class BOJ_1717_집합의표현 {
	static int N, M;
	static int[] parents;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();

		parents = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int c = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();

			if (c == 0) {
				union(a, b);
			} else if (c == 1) {
				if(find(a)==find(b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
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
		} else {
			return parents[x] = find(parents[x]);
		}
	}
}
