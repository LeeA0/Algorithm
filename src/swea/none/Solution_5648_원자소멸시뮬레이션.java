package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// SW_원자소멸시뮬레이션_5648
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo&categoryId=AWXRFInKex8DFAUo&categoryType=CODE&problemTitle=5648&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
public class Solution_5648_원자소멸시뮬레이션 {
	static class Atomic {
		int dir;
		int energy;

		public Atomic(int dir, int energy) {
			this.dir = dir;
			this.energy = energy;
		}

		@Override
		public String toString() {
			return "Atomic [dir=" + dir + ", energy=" + energy + "]";
		}
		
	}

	static class Room {
		int cnt = 0;
		Queue<Atomic> list = new LinkedList<>();

		public Room() {}

		@Override
		public String toString() {
			return "Room [cnt=" + cnt + ", list=" + list + "]";
		}
	}

	// 상 하 좌 우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int energy_sum = 0;
			Room[][] map = new Room[2001][2001];
			Queue<int[]> que = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) + 1000;
				int y = Integer.parseInt(st.nextToken()) + 1000;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				que.offer(new int[] { x, y });
				map[x][y] = new Room();
				map[x][y].cnt++;
				map[x][y].list.offer(new Atomic(d, e));

			}
			// 시간 흐름
			while (!que.isEmpty()) {
				move(map, que);
				energy_sum += delete(map, que);
			}
			sb.append("#").append(t).append(" ").append(energy_sum).append("\n");
		}
		System.out.print(sb);
	}

	static void move(Room[][] map, Queue<int[]> que) {
		int size = que.size();
		for (int i = 0; i < size; i++) {
			int[] curr = que.poll();
			map[curr[0]][curr[1]].cnt--;
			Atomic curAtomic = map[curr[0]][curr[1]].list.poll();
			curr[0] += dir4[curAtomic.dir][0];
			curr[1] += dir4[curAtomic.dir][1];
			if (!check(curr[0], curr[1])) {
				continue;
			}
			que.offer(curr);
			if (map[curr[0]][curr[1]] == null) {
				map[curr[0]][curr[1]] = new Room();
			}
			map[curr[0]][curr[1]].cnt++;
			map[curr[0]][curr[1]].list.offer(curAtomic);

		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < 2001 && y >= 0 && y < 2001;
	}

	static int delete(Room[][] map, Queue<int[]> que) {
		int sum = 0;
		int size = que.size();
		for (int i = 0; i < size; i++) {
			int[] curr = que.poll();
			if (map[curr[0]][curr[1]] != null && map[curr[0]][curr[1]].cnt > 1) {
				while (!map[curr[0]][curr[1]].list.isEmpty()) {
					sum += map[curr[0]][curr[1]].list.poll().energy;
				}
				map[curr[0]][curr[1]].cnt = 0;
			}
		}
		return sum;
	}
}
