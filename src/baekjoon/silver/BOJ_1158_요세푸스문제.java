package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BOJ_1158_요세푸스문제_실버5
public class BOJ_1158_요세푸스문제 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;

		LinkedList<Integer> numbers = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			numbers.add(i);
		}

		StringBuilder sb = new StringBuilder("<");
		int idx = 0;
		while (numbers.size() != 0) {
			idx = (idx + K) % numbers.size();
			sb.append(numbers.get(idx));
			if (numbers.size() != 1) {
				sb.append(", ");
			}
			numbers.remove(idx);
		}
		sb.append(">");
		System.out.println(sb.toString());
		br.close();
	}
}
