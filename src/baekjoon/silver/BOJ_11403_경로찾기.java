package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_경로찾기_11403_실버1
public class BOJ_11403_경로찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] adjmatrix = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjmatrix[i][j]=(Integer.parseInt(st.nextToken())==1);
			}
		} // 입력완료
		
		// 경유지
		for (int k = 0; k < N; k++) {
			// 출발지
			for (int i = 0; i < N; i++) {
				// 도착지
				for (int j = 0; j < N; j++) {
					// 경유지를 거쳐서 갈 수 있는 곳이면 true처리
					if(adjmatrix[i][k]&&adjmatrix[k][j]) {
						adjmatrix[i][j]=true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 갈 수 있는 곳이면 1 없는 곳이면 0을 출력
				sb.append(adjmatrix[i][j]?1:0).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
