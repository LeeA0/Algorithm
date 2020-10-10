package baekjoon.silver;
import java.util.Scanner;

//백준_바이러스_2606_실버3
public class BOJ_2606_바이러스 {
	static int N, M;
	static int[] parents;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();

		parents = new int[N + 1];
		// make-set
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		//연결 입력
		for (int i = 0; i < M; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			union(a, b);
		}

		int count = 0;
		//첫번째 컴퓨터는 셀 필요 없으므로 2부터 시작
		//백준 테케 중에 1이 루트가 아닌 경우가 존재하는 지 find(1)해줘야 통과됨.
		for (int i = 2; i <= N; i++) {
			if (find(i) == find(1)) {
				count++;
			}
		}
		System.out.println(count);
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
