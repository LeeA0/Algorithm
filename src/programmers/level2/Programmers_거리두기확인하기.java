package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Programmers_거리두기확인하기_level2
public class Programmers_거리두기확인하기 {
	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(Arrays.toString(solution(places)));
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int i = 0; i < 5; i++) {
			answer[i] = waitingPlaceConfirm(places[i]);
		}
		return answer;
	}

	public static int waitingPlaceConfirm(String[] place) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (place[i].charAt(j) == 'P') {
					if (!isKeepDistance(i, j, place)) {
						return 0;
					}
				}
			}
		}
		return 1;
	}

	private static boolean isKeepDistance(int x, int y, String[] place) {
		int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		Queue<int[]> saveLocation = new LinkedList<int[]>();
		// 방문했던 부분을 또 방문하면 안되므로 방문처리 배열 생성
		boolean[][] isVisited = new boolean[5][5];
		saveLocation.offer(new int[] { x, y });
		isVisited[x][y] = true;
		
		for (int i = 0; i < 2; i++) {
			int size = saveLocation.size();
			for (int j = 0; j < size; j++) {
				int[] curr = saveLocation.poll();
				for (int[] d : dir4) {
					int nx = curr[0] + d[0];
					int ny = curr[1] + d[1];
					if (!checkArea(nx, ny) || isPartition(place[nx].charAt(ny)) || isVisited[nx][ny]) {
						continue;
					}
					if (isPerson(place[nx].charAt(ny))) {
						return false;
					}
					saveLocation.offer(new int[] { nx, ny });
					isVisited[nx][ny] = true;
				}
			}
		}

		return true;
	}

	public static boolean isPerson(char curr) {
		return curr == 'P';
	}

	public static boolean isPartition(char curr) {
		return curr == 'X';
	}

	public static boolean checkArea(int x, int y) {
		return 0 <= x && x < 5 && 0 <= y && y < 5;
	}
}
