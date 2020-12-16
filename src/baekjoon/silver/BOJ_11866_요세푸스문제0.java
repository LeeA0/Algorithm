package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준_요세푸스문제0_11866_실버4
public class BOJ_11866_요세푸스문제0 {
	static int N, K;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int index = 0;
		while (true) {
			index = (index+K-1) % list.size();
			sb.append(list.get(index)+1);
			list.remove(index);
			if(!list.isEmpty()) {
				sb.append(", ");
			}
			else {
				break;
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}
