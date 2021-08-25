package programmers.level3;

// Programmers_자물쇠와열쇠_level3
public class Programmers_자물쇠와열쇠 {
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(key, lock));
	}

	static int M, N;

	public static boolean solution(int[][] key, int[][] lock) {
		// 사용하기 편하도록 키의 크기와 자물쇠의 크기를 저장
		M = key.length;
		N = lock.length;
		// 4방향 회전
		for (int r = 0; r < 4; r++) {
			// 자물쇠의 대각선 맨 위방향부터 대각선 맨 아래방향까지 키를 대조해봄
			for (int x = -N + 1; x < N; x++) {
				for (int y = -N + 1; y < N; y++) {
					// 자물쇠에 키가 맞음
					if (isMatch(x, y, key, lock)) {
						return true;
					}
				}
			}
			// 키 회전
			key = rotation(key);
		}
		return false;
	}

	// 키 회전
	public static int[][] rotation(int[][] key) {
		// 회전한 키를 저장하는 변수
		int[][] rotateKey = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				rotateKey[j][M - 1 - i] = key[i][j];
			}
		}
		return rotateKey;
	}

	// 키와 자물쇠가 일치하는지 확인
	public static boolean isMatch(int startX, int startY, int[][] key, int[][] lock) {
		// 자물쇠 전체를 탐색
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				// 키와 맞닿은 부분이면 키의 돌기와 자물쇠의 홈이 맞는지 확인해 맞지 않으면 실패
				if (0 <= x - startX && x - startX < M && 0 <= y - startY && y - startY < M) {
					if (key[x - startX][y - startY] == lock[x][y]) {
						return false;
					}
				}
				// 키와 맞닿지 않은 부분이면 홈인지 확인해서 키와 맞물리지 못한 홈이 있으면 실패
				else if (lock[x][y] == 0) {
					return false;
				}
			}
		}
		// 전부 통과하면 성공
		return true;
	}
}
