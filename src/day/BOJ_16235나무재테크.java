package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16235나무재테크 {
	static int N, M, K;
	static Field[][] A;

	static class Field {
		int robot, food, deadTreeAge, fiveAgeTreeNum;
		PriorityQueue<Integer> trees;

		public Field(int robot, int food, int deadTreeAge, int fiveAgeTreeNum, PriorityQueue<Integer> trees) {
			this.robot = robot;
			this.food = food;
			this.deadTreeAge = deadTreeAge;
			this.fiveAgeTreeNum = fiveAgeTreeNum;
			this.trees = trees;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new Field[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = new Field(Integer.parseInt(st.nextToken()), 5, 0, 0, new PriorityQueue<>());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int treeAge = Integer.parseInt(st.nextToken());
			A[x][y].trees.offer(treeAge);
		} // 입력 완료

		for (int i = 0; i < K; i++) {
			spring();
			print();
			summer();
			print();
			autumn();
			print();
			winter();
			print();
		}

		System.out.println(count());
	}

	public static void print() {
		System.out.println("==========나무===========");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(A[i][j].trees + " ");
			}
			System.out.println();
		}
		System.out.println("==========양분===========");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(A[i][j].food + " ");
			}
			System.out.println();
		}
	}

	public static void spring() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				PriorityQueue<Integer> tempTree = new PriorityQueue<>();
				int size = A[i][j].trees.size();
				for (int k = 0; k < size; k++) {
					if (A[i][j].food - A[i][j].trees.peek() > 0) {
						int tree = A[i][j].trees.poll();
						A[i][j].food -= tree;
						tempTree.offer(tree + 1);
						if ((tree + 1) % 5 == 0) {
							A[i][j].fiveAgeTreeNum++;
						}
					} else {
						A[i][j].deadTreeAge += A[i][j].trees.poll();
					}
				}
				A[i][j].trees = tempTree;
			}
		}
	}

	public static void summer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j].food += (A[i][j].deadTreeAge / 2);
				A[i][j].deadTreeAge = 0;
			}
		}
	}

	public static void autumn() {
		int[][] dir8 = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j].fiveAgeTreeNum > 0) {
					for (int[] d : dir8) {
						int nx = i + d[0];
						int ny = j + d[1];
						if (nx < 0 || nx >= N || ny < 0 || ny >= N)
							continue;
						for (int t = 0; t < A[i][j].fiveAgeTreeNum; t++) {
							A[nx][ny].trees.offer(1);
						}
					}
					A[i][j].fiveAgeTreeNum = 0;
				}
			}
		}
	}

	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j].food += A[i][j].robot;
			}
		}
	}

	public static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += A[i][j].trees.size();
			}
		}
		return cnt;
	}
}
