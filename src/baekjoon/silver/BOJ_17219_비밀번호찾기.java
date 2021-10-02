package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// BOJ_17219_비밀번호찾기_실버4
public class BOJ_17219_비밀번호찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> sitePassword = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			String site = st.nextToken();
			String password = st.nextToken();
			sitePassword.put(site, password);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String site = br.readLine();
			sb.append(sitePassword.get(site)).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
}
