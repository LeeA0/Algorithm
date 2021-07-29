package programmers.level2;

import java.util.Arrays;

// Programmers_삼각달팽이_level2
public class Programmers_삼각달팽이 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(int n) {
		// 맨 끝 숫자는 1+2+3+...+n이므로 공식을 사용
		int size = n*(n+1)/2;
		// 삼각모양으로 순환하기 위해 2차원 배열 생성
		int[][] save = new int[n][n];
		// 세방향(하,우,상좌)
		int[][] dir3 = { { 1, 0 }, { 0, 1 }, { -1, -1 } };
		// 배열에 넣을 숫자
		int num = 1;
		// x, y좌표
		int x = 0;
		int y = 0;
		// 방향
		int d = 0;
		// num이 size를 넘지 않을 때까지 반복
		while (num <= size) {
			// 좌표에 숫자를 넣음
			save[x][y] = num++;
			// 이동하던 방향으로 이동
			x += dir3[d][0];
			y += dir3[d][1];
			// 이동한 좌표가 영역을 벗어났거나 좌표에 이미 다른 숫자가 있으면
			if (!(0 <= x && x < n && 0 <= y && y < n) || save[x][y] != 0) {
				// 한 칸 후진
				x -= dir3[d][0];
				y -= dir3[d][1];
				// 방향 변경
				d = (d + 1) % 3;
				// 변경된 방향으로 한 칸 전진
				x += dir3[d][0];
				y += dir3[d][1];
			}
		}
		// 정답을 넣을 배열
		int[] answer = new int[size];
		// answer의 index
		int idx = 0;
		// 아래 직삼각형 모양의 숫자를 행우선 순회하며 answer에 저장
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[idx++] = save[i][j];
			}
		}
		return answer;
	}
}
