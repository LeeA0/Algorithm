package programmers.level2;

import java.util.Arrays;

// Programmers_배달_level2
// using floyd warshal
public class Programmers_배달 {

	public static void main(String[] args) {
//		int N = 5;
//		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
//		int K = 3;
		int N = 6;
		int[][] road = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
		int K = 4;
		System.out.println(solution(N, road, K));
	}

	public static int solution(int N, int[][] road, int K) {
		// i->j로 이동하는 거리를 저장하는 맵
		int[][] map = new int[N][N];
		// 플로이드 워셜 사용을 위해 전부 최댓값으로 초기화
		// K의 최댓값이 500000이므로 넉넉하게 1000000을 줌
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 1000000);
		}

		// 자기지역으로 돌아오는건 시간이 필요없으므로 0
		for (int i = 0; i < N; i++) {
			map[i][i] = 0;
		}

		// i->j로 이동하는 길은 여러가지가 있으므로 이 중에서 가장 시간이 적게 걸리는 길을 선택
		for (int i = 0; i < road.length; i++) {
			int from = road[i][0] - 1;
			int to = road[i][1] - 1;
			int dist = road[i][2];

			// 양방향이므로 양방향으로 넣어줌
			map[from][to] = Math.min(map[from][to], dist);
			map[to][from] = Math.min(map[to][from], dist);
		}

		// 경유지
		for (int k = 0; k < N; k++) {
			// 출발지
			for (int i = 0; i < N; i++) {
				// 도착지
				for (int j = 0; j < N; j++) {
					// 현재 i->j로 걸리는 시간과 k를 경유해서 i에서 j로 가는데 걸리는 시간 중 짧은 것을 넣음
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		int answer = 0;
		// i->j로 이동하는데 K보다 적거나 같게 걸리면 배달 가능한 도시에 추가
		for (int i = 0; i < N; i++) {
			if (map[0][i] <= K) {
				answer++;
			}
		}
		return answer;
	}
}
