package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_마법사상어와파이어볼_20056_골드5_다시풀기ㅠㅠ
public class BOJ_20056_마법사상어와파이어볼 {
	static class Fireball implements Comparable<Fireball> {
		int x;
		int y;
		int m;
		int s;
		int d;

		public Fireball(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public int compareTo(Fireball o) {
			if (this.x != o.x) {
				return Integer.compare(this.x, o.x);
			} else {
				return Integer.compare(this.y, o.y);
			}
		}

		@Override
		public String toString() {
			return "Fireball [x=" + x + ", y=" + y + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
	}

	static int N, M, K;
	static int[][] dir8 = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Fireball> que = new LinkedList<>();
		// 파이어볼 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			que.offer(new Fireball(x, y, m, s, d));
		}

		for (int k = 0; k < K; k++) {
			int size = que.size();
			// 이동한 파이어볼을 저장할 임시 pq생성
			PriorityQueue<Fireball> pq = new PriorityQueue<>();
			// 모든 파이어볼 이동 시키기
			for (int i = 0; i < size; i++) {
				Fireball curr = que.poll();
				// 파이어볼 이동
				for (int j = 0; j < curr.s; j++) {
					curr.x = (curr.x + dir8[curr.d][0]) % N;
					curr.x = curr.x >= 0 ? curr.x : curr.x + N;
					curr.y = (curr.y + dir8[curr.d][1]) % N;
					curr.y = curr.y >= 0 ? curr.y : curr.y + N;
				}
				pq.add(curr);
			}
			size = pq.size();
			LinkedList<Fireball> temp = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				Fireball curr = pq.poll();
				// 다음 파이어볼이 있을 때
				if (!pq.isEmpty()) {
					// 다음 파이어볼과 위치가 같을 때 => 한칸에 2개이상의 파이어볼이 있다는 이야기
					if (curr.x == pq.peek().x && curr.y == pq.peek().y) {
						temp.add(curr);
					} else {
						// 해당 칸에 파이어볼이 1개 있을 때 그대로 저장
						if (temp.size() == 0) {
							que.offer(curr);
						}
						// 해당 칸에 파이어볼이 2개 이상 있을 때 파이어볼을 4개로 나눔
						else {
							temp.add(curr);
							divFire(que, temp);
							temp.clear();
						}
					}
				}
				// 다음 파이어볼이 없을 때
				else {
					// 해당 칸에 파이어볼이 1개 있을 때 그대로 저장
					if (temp.size() == 0) {
						que.offer(curr);
					}
					// 해당 칸에 파이어볼이 2개 이상 있을 때 파이어볼을 4개로 나눔
					else {
						temp.add(curr);
						divFire(que, temp);
						temp.clear();
					}
				}
			}
		}

		// 남아있는 파이어볼 질량의 합
		int answer = 0;
		while (!que.isEmpty()) {
			// Fireball t = que.poll();
			// System.out.println(t);
			// answer += t.m;
			answer += que.poll().m;
		}
		System.out.println(answer);
	}

	private static void divFire(Queue<Fireball> que, LinkedList<Fireball> temp) {
		int sum_m = 0, sum_s = 0;
		for (int i = 0; i < temp.size(); i++) {
			sum_m += temp.get(i).m;
			sum_s += temp.get(i).s;
		}
		int m = sum_m / 5;
		if (m == 0) {
			return;
		} else {
			int s = sum_s / temp.size();
			// 짝수면 0, 홀수면 1
			int isOddEven = temp.get(0).d % 2;
			for (int i = 1; i < temp.size(); i++) {
				if (isOddEven != temp.get(i).d % 2) {
					isOddEven = 2;
					break;
				}
			}
			// 어처피 temp에 있는 x,y값은 같음
			int x = temp.get(0).x;
			int y = temp.get(0).y;

			// 0,2,4,6
			int d = 0;
			// 1,3,5,7
			if (isOddEven == 2) {
				d = 1;
			}

			for (int i = 0; i < 4; i++) {
				que.offer(new Fireball(x, y, m, s, d));
				d += 2;
			}
		}
	}
}
