package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//백준_나는야  포켓몬 마스터 이다솜_1620_실버4
public class BOJ_1620_나는야포켓몬마스터이다솜 {
	static int N, M;
	static HashMap<Integer, String> pocketmon;
	static HashMap<String, Integer> pocketmon2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pocketmon = new HashMap<Integer, String>();
		pocketmon2 = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			String name = br.readLine().trim();
			pocketmon.put(i + 1, name);
			pocketmon2.put(name, i + 1);
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while (cnt++ < M) {
			String question = br.readLine().trim();
			char question_char = question.charAt(0);

			// 문제가 숫자면
			if (Character.isDigit(question_char)) {
				int question_int = Integer.parseInt(question);
				sb.append(pocketmon.get(question_int)).append("\n");
			}
			// 문제가 문자열이면
			else {
				sb.append(pocketmon2.get(question)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
