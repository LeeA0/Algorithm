package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준_1764_듣보잡_실버4
public class BOJ_1764_듣보잡 {
	static int N, M;
	static HashMap<String, String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			list.put(br.readLine().trim(), "");
		}
		LinkedList<String> answerlist = new LinkedList<String>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine().trim();
			if(list.containsKey(name)) {
				answerlist.add(name);
			}
		}
		Collections.sort(answerlist);
		StringBuilder sb = new StringBuilder().append(answerlist.size()).append("\n");
		for (String a : answerlist) {
			sb.append(a).append("\n");
		}
		System.out.println(sb.toString());
	}
}
