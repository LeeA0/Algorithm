package programmers.level2;

public class Programmers_가장큰정사각형찾기 {
	// bfs를 사용했더니 효율성 시간초과 ㅠ
	// => 다른방법!!
	// DP?
	/**
	 * 0111 1111 1111 0010 인 경우 1인 경우 왼쪽위, 왼쪽, 위의 숫자 중 최솟값+1을 해준다 01 1? => ?=0+1
	 * 완성하면 다음과 같다 0111 1122 1223 0010 => 제일 큰 숫자인 3의 제곱이 정답! => 9
	 */
	public static void main(String[] args) {
//		int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
//		int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int[][] board = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		// 최대 변의 길이를 저장하는 변수
		int max = 0;
		// 전체 행렬 탐색
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// 맨 윗줄 혹은 왼쪽 줄이아니고, 1인 경우
				if (i != 0 && j != 0 && board[i][j] == 1) {
					// 왼쪽위, 위, 왼쪽 중 최소값을 찾아 더해줌(기존 값이 1이므로 +1해준 값과 동일)
					board[i][j] += Math.min(board[i - 1][j - 1], Math.min(board[i][j - 1], board[i - 1][j]));
				}
				// 값이 max보다 크면 갱신
				max = Math.max(max, board[i][j]);
			}
		}
		// 변의 제곱이 넒이이므로 제곱
		return max * max;
	}

	// bfs를 사용했더니 효율성 시간초과 ㅠ
//	public static int solution(int[][] board) {
//		int answer = 0;
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				if (board[i][j] == 1) {
//					answer = Math.max(answer, bfs(i, j, board));
//				}
//			}
//		}
//		return answer;
//	}
//
//	public static int bfs(int x, int y, int[][] board) {
//		int[][] dir3 = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
//		Queue<int[]> que = new LinkedList<int[]>();
//		boolean[][] isVisited = new boolean[board.length][board[0].length];
//		que.offer(new int[] { x, y });
//		int area = 0;
//		a: while (!que.isEmpty()) {
//			int size = que.size();
//			area += size;
//			for (int i = 0; i < size; i++) {
//				int[] curr = que.poll();
//				for (int[] d : dir3) {
//					int nx = curr[0] + d[0];
//					int ny = curr[1] + d[1];
//					if (!(0 <= nx && nx < board.length && 0 <= y && ny < board[0].length) || board[nx][ny] == 0) {
//						break a;
//					}
//					if (!isVisited[nx][ny]) {
//						que.offer(new int[] { nx, ny });
//						isVisited[nx][ny] = true;
//					}
//				}
//			}
//		}
//		return area;
//	}
}
