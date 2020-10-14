package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//dist가 int일 때
//백준_9205_맥주 마시면서 걸어가기_실버1
public class BOJ_9205_맥주마시면서걸어가기 {
	static int T, N;
	static int[][] dist;
	static LinkedList<int[]> point;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine().trim());

			point = new LinkedList<int[]>();
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				point.add(new int[] { x, y });
			}
			////////////////// 입력완료//////////////////

			// 인접행렬 생성
			dist = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i != j) {
						dist[i][j] = 1000;
						if (getdist(point.get(i), point.get(j)) <= 1000) {
							// 갈 수 있다.
							dist[i][j] = 1;
						}
					}
				}
			}

			// 플루이드
			// 경유하는 정점
			for (int k = 0; k < N + 2; k++) {
				// 출발하는 정점
				for (int i = 0; i < N + 2; i++) {
					// 도착하는 정점
					for (int j = 0; j < N + 2; j++) {
						dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
					}
				}
			}

			// 가능하다면 거리값이 1~N+1이다.
			// 락페스티발에 가려면 1번 이상 이동해야하고,
			// 주어진 모든 편의점을 전부 돌았다고 할때 최대 이동 회수는 N+1이다.
			if (0 < dist[0][N + 1] && dist[0][N + 1] < N + 2) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}

	public static void print() {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int getdist(int[] start, int[] end) {
		return Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]);
	}
}
