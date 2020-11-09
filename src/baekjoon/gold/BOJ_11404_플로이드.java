package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준_플로이드_11404_골드4
public class BOJ_11404_플로이드 {
	static int n, m, answer;
	static int[][] adjmatrix;
	static final int infinite = 10000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		m = Integer.parseInt(br.readLine().trim());

		adjmatrix = new int[n][n];
		// 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(adjmatrix[i], infinite);
			// 이걸 씀으로써 for문 안에서의 if문 실행을 없앨 수 있다..! -> 그치만 속도가 빨라지진않는다...
			adjmatrix[i][i] = 0; 
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adjmatrix[from][to] = Math.min(adjmatrix[from][to], weight);
		}

		// 경유지
		for (int k = 0; k < n; k++) {
			// 출발지
			for (int i = 0; i < n; i++) {
				// 도착지
				for (int j = 0; j < n; j++) {
					//if(i!=j&&i!=k&&k!=j)
					adjmatrix[i][j] = Math.min(adjmatrix[i][j], adjmatrix[i][k] + adjmatrix[k][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (adjmatrix[i][j] >= infinite) {
					sb.append(0).append(" ");
				} else {
					sb.append(adjmatrix[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
