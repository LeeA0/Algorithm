package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// Programmers_프렌즈4블록_level2
public class Programmers_프렌즈4블록 {
	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		System.out.println(solution(m, n, board));
	}

	public static int solution(int m, int n, String[] board) {
		// String 1차원 배열을 char 2차원 배열로 변경하기 위한 변수
		char[][] puzzle = new char[m][n];
		// 형변환
		for (int i = 0; i < board.length; i++) {
			puzzle[i] = board[i].toCharArray();
		}
		// 터진 블록의 개수
		int answer = 0;
		// 더 이상 사라질 블록이 없을 때까지 반복
		while (true) {
			// 사라질 블록이 있는지 여부
			boolean flag = true;
			// 사라질 블록의 위치를 판별하기위한 배열
			boolean[][] bomb = new boolean[m][n];
			// 전체 배열을 조회하면서 터질 블록이 있는지 체크
			// 기준이 되는 블록이 m-2,n-2까지이기 때문에 범위를 이렇게 잡음
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					// 기준이 되는 블록
					char st = puzzle[i][j];
					// 기준이 되는 블록이 공백이 아니고, 2x2방향으로 같을 때
					if (st != '*' && st == puzzle[i + 1][j] && st == puzzle[i][j + 1] && st == puzzle[i + 1][j + 1]) {
						// 터진 블록이 있음
						flag = false;
						// 블록이 터진다는 걸 체크
						bomb[i][j] = true;
						bomb[i + 1][j] = true;
						bomb[i][j + 1] = true;
						bomb[i + 1][j + 1] = true;
					}
				}
			}
			// 터진 블록이 있으면 나머지 블록을 밑으로 내림
			if (!flag) {
				// 터진 블록을 체크하며 밑으로 내려주기위해 행을 안쪽에 열을 바깥쪽으로 반복
				for (int j = 0; j < n; j++) {
					// 안 터진 블록을 임시 저장하기 위한 queue
					// Queue를 사용한 이유: 선입선출
					Queue<Character> save = new LinkedList<>();
					// 행을 기준으로 반복
					for (int i = m - 1; i >= 0; i--) {
						// 터진 블록이면 answer을 1증가
						if (bomb[i][j]) {
							answer++;
						}
						// 터지지 않은 블록이면 임시 저장
						else {
							save.offer(puzzle[i][j]);
						}
					}
					for (int i = m - 1; i >= 0; i--) {
						// Queue가 비어있지않으면 밑에서부터 쌓음
						if (!save.isEmpty()) {
							puzzle[i][j] = save.poll();
						}
						// Queue가 비어있으면 공백의 의미로 *을 채움
						else {
							puzzle[i][j] = '*';
						}
					}
				}
			}
			// 만약 하나라도 터질 블록이 없으면 멈춤
			else {
				break;
			}
		}
		return answer;
	}
}
