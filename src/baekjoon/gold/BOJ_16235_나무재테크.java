package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ_나무재테크_16235_골드4
public class BOJ_16235_나무재테크 {
	// N: 맵크기
	// M: 초기 나무 수
	// K: 년도
	// A: 맵
	static int N, M, K;
	static Field[][] A;

	// 밭 한 칸
	static class Field {
		// robot: 로봇이 겨울에 주는 양분 양
		// food: 양분
		// fiveAgeTreeNum: 5의 배수인 나이를 가진 나무의 수
		int robot, food, fiveAgeTreeNum;
		// trees: 나무들
		// deadTrees: 죽은 나무들
		PriorityQueue<Integer> trees, deadTrees;

		public Field(int robot, int food, int fiveAgeTreeNum, PriorityQueue<Integer> deadTrees,
				PriorityQueue<Integer> trees) {
			this.robot = robot;
			this.food = food;
			this.deadTrees = deadTrees;
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
				A[i][j] = new Field(Integer.parseInt(st.nextToken()), 5, 0, new PriorityQueue<>(),
						new PriorityQueue<>());
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
			// 봄
			spring();
			// 여름
			summer();
			// 가을
			autumn();
			// 겨울
			winter();
		}
		// K년 후 나무 수
		System.out.println(count());
	}

	/*
	 * 봄
	 * 1. 나무의 나이만큼 양분을 뺀다
	 * - 하나의 칸에 여러 개의 나무가 있는 경우 나이가 어린 나무부터 양분을 흡수한다
	 * - 남은 양분보다 나무의 나이가 크면 나무는 죽는다
	 * 2. 나무의 나이를 +1
	 */
	public static void spring() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 나이를 증가시킨 나무를 임시로 저장하는 PQ
				PriorityQueue<Integer> tempTree = new PriorityQueue<>();
				// 해당 밭에 있는 모든 나무를 조회한다
				while (!A[i][j].trees.isEmpty()) {
					// 현재 밭에 있는 양분 - 나무의 양분이 0보다 크거나 같으면
					if (A[i][j].food - A[i][j].trees.peek() >= 0) {
						// 편의성을 위한 나무의 나이 저장
						int tree = A[i][j].trees.poll();
						// 밭의 양분을 나무의 나이만큼 빼준다
						A[i][j].food -= tree;
						// 나무가 나이를 먹었다
						tree++;
						// 나이먹은 나무를 임시저장소에 저장
						tempTree.offer(tree);
						// 만약 나이가 5의 배수이면
						if (tree % 5 == 0) {
							// 5의 배수인 나무 개수 +1
							A[i][j].fiveAgeTreeNum++;
						}
					} 
					// 남은 양분보다 나무의 나이가 크면 나무는 죽는다
					else {
						// 죽은 나무에 추가한다
						A[i][j].deadTrees.offer(A[i][j].trees.poll());
					}
				}
				// 임시저장소에 저장한 나무를 밭의 나무 리스트에 옮긴다
				A[i][j].trees = tempTree;
			}
		}
	}

	/*
	 * 여름
	 * 봄에 죽은 나무가 양분으로 변한다
	 * (죽은 나무의 각 나이)/2 -> 소수점아래버림
	 */
	public static void summer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 죽은 나무들을 조회한다
				while (!A[i][j].deadTrees.isEmpty()) {
					// 계산해서 양분으로 변화
					A[i][j].food += (A[i][j].deadTrees.poll() / 2);
				}
			}
		}
	}

	/* 
	 * 가을
	 * 5의 배수인 나무만 인접한 8칸에 나이가 1인 나무 생성
	 */
	public static void autumn() {
		// 8방향
		int[][] dir8 = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 해당 칸에 나이가 5의 배수인 나무가 1개라도 있으면
				if (A[i][j].fiveAgeTreeNum > 0) {
					// 8방향 순회
					for (int[] d : dir8) {
						int nx = i + d[0];
						int ny = j + d[1];
						// 밭의 영역을 벗어나면 넘김
						if (nx < 0 || nx >= N || ny < 0 || ny >= N)
							continue;
						// 해당 밭의 번식가능 나무 수 만큼 인접한 영역에 나이가 1인 나무를 추가
						for (int t = 0; t < A[i][j].fiveAgeTreeNum; t++) {
							A[nx][ny].trees.offer(1);
						}
					}
					// 다 추가했으므로 초기화
					A[i][j].fiveAgeTreeNum = 0;
				}
			}
		}
	}

	/*
	 * 겨율
	 * 로봇이 정해진 양만큼 양분을 추가한다
	 */
	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j].food += A[i][j].robot;
			}
		}
	}

	// 각 밭에 남은 나무의 수를 전부 센다
	public static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += A[i][j].trees.size();
			}
		}
		return cnt;
	}
	

	public static void print() {
		System.out.println("==========5의 배수 나무===========");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(A[i][j].fiveAgeTreeNum + " ");
			}
			System.out.println();
		}
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
}
