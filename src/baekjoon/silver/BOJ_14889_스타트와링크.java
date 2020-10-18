package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
//백준_스타트와 링크_14889_실버3
public class BOJ_14889_스타트와링크 {
	static int N, min;
	static int[][] S;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		S = new int[N][N];
		select = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		nCr(0, 0);
		System.out.println(min);
	}

	public static void nCr(int cnt, int start) {
		if (cnt == N / 2) {
			ArrayList<Integer> sTeam = new ArrayList<Integer>();
			ArrayList<Integer> lTeam = new ArrayList<Integer>();

			// 팀원들 저장
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					sTeam.add(i);
				} else {
					lTeam.add(i);
				}
			}
			int sScore = 0;
			// 스타트팀 능력치 계산
			for (int i = 0; i < sTeam.size(); i++) {
				for (int j = i + 1; j < sTeam.size(); j++) {
					sScore += S[sTeam.get(i)][sTeam.get(j)];
					sScore += S[sTeam.get(j)][sTeam.get(i)];
				}
			}
			
			int lScore = 0;
			// 링크팀 능력치 계산
			for (int i = 0; i < lTeam.size(); i++) {
				for (int j = i + 1; j < lTeam.size(); j++) {
					lScore += S[lTeam.get(i)][lTeam.get(j)];
					lScore += S[lTeam.get(j)][lTeam.get(i)];
				}
			}
			//팀의 능력치가 최소면 저장
			min = Math.min(min, Math.abs(sScore-lScore));
			
			return;
		}
		for (int i = start; i < N; i++) {
			select[i] = true;
			nCr(cnt + 1, i + 1);
			select[i] = false;
		}
	}

}
