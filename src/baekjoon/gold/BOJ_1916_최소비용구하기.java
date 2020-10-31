package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준_최소비용구하기_1916_골드5
public class BOJ_1916_최소비용구하기 {
	static int N, M;
	static int[][] adjmatrix;
	static boolean[] visited;
	static int[] distance; // 출발지에서 해당 정점까지 오는데 드는 비용
	static final int MAXINT = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());

		visited = new boolean[N + 1];
		distance = new int[N + 1];
		adjmatrix = new int[N + 1][N + 1];
		// 가장 큰 값으로 배열 채우기
		for (int i = 1; i <= N; i++) {
			Arrays.fill(adjmatrix[i], MAXINT);
		}

		//인접행렬 입력
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			adjmatrix[from][to] = Math.min(adjmatrix[from][to], dist); // ***매우중요***
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 각 점의 거리를 최대로 초기화
		Arrays.fill(distance, MAXINT);

		visited[start] = true;
		distance[start] = 0;
		// 1. start정점에서 각 정점까지 거리 넣기
		for (int i = 1; i <= N; i++) {
			distance[i] = adjmatrix[start][i];
		}
		int current = start;
		for (int i = 1; i <= N; i++) {
			// 2. 인접한 정점 중 최소거리인 값을 선택
			int min = MAXINT;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true;
			if (current == end) {
				break;
			}

			// 3. current에 인접한 모든 미방문 정점 v의 distance
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					distance[j] = Math.min(distance[j], distance[current] + adjmatrix[current][j]);
				}
			}
		}
		System.out.println(distance[end]);
	}
}
