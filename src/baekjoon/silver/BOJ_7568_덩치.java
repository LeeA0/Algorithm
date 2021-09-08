package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_7568_덩치_실버5
public class BOJ_7568_덩치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 사람 수
		int N = Integer.parseInt(br.readLine());
		// 등수
		int[] rank = new int[N];
		// 사람의 키와 몸무게 정보
		int[][] dungchi = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			dungchi[i][0] = Integer.parseInt(st.nextToken());
			dungchi[i][1] = Integer.parseInt(st.nextToken());
			//1로 초기화한 후 자신보다 큰 사람이 있을 때마다 +1 해줄 것
			rank[i] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				// j보다 i가 덩치가 크면 j의 순위를 1증가
				if (dungchi[i][0] > dungchi[j][0] && dungchi[i][1] > dungchi[j][1]) {
					rank[j]++;
				} 
				// i보다 j가 덩치가 크면 i의 순위를 1증가
				else if (dungchi[i][0] < dungchi[j][0] && dungchi[i][1] < dungchi[j][1]) {
					rank[i]++;
				}
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(rank[0]);
		for (int i = 1; i < N; i++) {
			sb.append(" ").append(rank[i]);
		}
		System.out.println(sb.toString());
	}
}
