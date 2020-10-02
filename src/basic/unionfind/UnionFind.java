package basic.unionfind;

//SW-3289, 백준-종교
public class UnionFind {
	static int[] parents, rank;

	public static void main(String[] args) {
		parents = new int[] { 1, 2, 3, 4, 5 };// make-set
		rank = new int[5];
		union(1, 2);
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (x == y) {
			return;
		}
		parents[py] = x;
	}

	private static void union_rank(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py) {
			return;
		}
		if (rank[px] > rank[py]) {
			parents[px] = py;
		} else {
			parents[py] = px;
			if (rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}

	private static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

}
