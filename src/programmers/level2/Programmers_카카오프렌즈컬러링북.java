package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Programmers_카카오프렌즈컬러링북_level2
public class Programmers_카카오프렌즈컬러링북 {
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		System.out.println(Arrays.toString(solution(m, n, picture)));
	}

	// 해당 영역을 체크하는 배열
	static boolean[][] check;

	public static int[] solution(int m, int n, int[][] picture) {
		// 영역 개수
		int numberOfArea = 0;
		// 가장 큰 영역의 넓이
		int maxSizeOfOneArea = 0;

		// m*n으로 생성
		check = new boolean[m][n];
		
		// 전체를 조회해서 체크하지 않은 영역이 있으면 체크해준다
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 체크하지 않았고, 0이 아닌 곳이면(0은 색칠하지 않는 영역)
				if (!check[i][j]&&picture[i][j]!=0) {
					// 영역의 개수 +1
					numberOfArea++;
					// 현재까지 가장 큰 영역의 넓이와 현재 넓이를 비교하여 큰 값을 가장 큰 영역의 넓이에 넣는다
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture, m, n));
				}
			}
		}

		// 정답 저장
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static int bfs(int x, int y, int[][] picture, int m, int n) {
		// 4방향
		int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// 해당 영역의 숫자(색깔)을 저장
		int num = picture[x][y];
		// 좌표를 저장하는 Queue선언
		Queue<int[]> que = new LinkedList<int[]>();
		// 첫 시작점을 넣는다
		que.offer(new int[] { x, y });
		// 첫 시작점을 체크했으므로 체크 표시
		check[x][y]=true;

		// 첫 시작점을 체크했으므로 1로 초기화
		int area = 1;
		// Queue가 비어있지 않은 동안 반복
		while (!que.isEmpty()) {
			// 한 개를 꺼낸다
			int[] curr = que.poll();
			// 해당 지점의 4방향을 탐색하여 연결된 영역을 찾는다
			for (int[] d : dir4) {
				// 4방향 중 한 곳
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				// 이동한 지점이 사진을 벗어났거나, 체크된 상태거나, 첫 지점과 번호(색깔)가 다르거나, 색칠하는 영역이 아니면 건너뜀
				if (!checked(nx, ny, m, n) || check[nx][ny] || picture[nx][ny] != num || picture[nx][ny] == 0) {
					continue;
				}
				// 조건을 충족하면 해당 지점 체크 표기
				check[nx][ny] = true;
				// 영역의 크기 +1
				area++;
				// 해당 지점과 연결된 영역을 찾기위해 Queue에 저장
				que.offer(new int[] { nx, ny });
			}
		}
		// 한 영역의 크기를 리턴
		return area;
	}

	// 영역을 벗어났는지 체크
	public static boolean checked(int x, int y, int m, int n) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
