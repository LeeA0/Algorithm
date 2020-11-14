package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SW_Contact_1238_D4
public class Solution_1238_Contact {
	static int MAXN = 100;
	static int[][] contact;
	static int[] visited;
	static int max;
	static int T = 10;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int L = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			contact = new int[MAXN + 1][MAXN + 1];
			visited = new int[MAXN + 1];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < L / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contact[from][to] = 1;
			}
			// 입접행렬과 BFS
			Queue<Integer> queue = new LinkedList<Integer>();
			visited[start] = 1;
			queue.offer(start);
			while (!queue.isEmpty()) {
				max = 0;
				int size = queue.size();
				for (int s = 0; s < size; s++) {
					int curr = queue.poll();
					if (curr > max) {
						max = curr;
					}
					for (int i = 0; i < MAXN + 1; i++) {
						if (visited[i] == 0 && contact[curr][i] == 1) {
							visited[i] = 1;
							queue.offer(i);
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}