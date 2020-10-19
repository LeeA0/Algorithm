package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//플루이드-와샬
//백준_키순서_2458_골드4
public class BOJ_2458_키순서 {

	static int N, M;
	static boolean[][] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		students = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			students[a][b] = true;
		}

		// 경유지
		for (int k = 1; k <= N; k++) {
			// 출발지
			for (int i = 1; i <= N; i++) {
				// 도착지
				for (int j = 1; j <= N; j++) {
					students[i][j] = students[i][j] || (students[i][k] && students[k][j]);
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 1; j <= N; j++) {
				if ((i!=j)&&(students[i][j] || students[j][i])) {
					count++;
				}
			}
			if (count == N - 1) {// 자기자신을 제외하고
				answer++;
			}
		}
		System.out.println(answer);
	}
}
