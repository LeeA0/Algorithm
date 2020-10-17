package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//백준_집합_11723_실버5
public class BOJ_11723_집합 {
	static int M;
	static HashSet<Integer> S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine().trim());
		S = new HashSet<Integer>();
		HashSet<Integer> temp = new HashSet<Integer>();
		for (int i = 1; i <= 20; i++) {
			temp.add(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			String cal = st.nextToken();
			int a = 0;
			if (st.hasMoreTokens()) {
				a = Integer.parseInt(st.nextToken());
			}
			switch (cal) {
			case "add":
				S.add(a);
				break;
			case "remove":
				S.remove(a);
				break;
			case "check":
				if(S.contains(a)) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				if (S.contains(a)) {
					S.remove(a);
				} else {
					S.add(a);
				}
				break;
			case "all":
				S.addAll(temp);
				break;
			case "empty":
				S.removeAll(S);
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
