package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//백준_덱_10866_실버4
public class BOJ_10866_덱 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		Deque<String> dq = new ArrayDeque<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			switch (st.nextToken()) {
			case "push_front":
				dq.addFirst(st.nextToken());
				break;
			case "push_back":
				dq.addLast(st.nextToken());
				break;
			case "pop_front":
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}
				sb.append(dq.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}
				sb.append(dq.pollLast()).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
//				if(dq.isEmpty()) {
//				sb.append(1:0).append("\n");
				break;
			case "front":
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}
				sb.append(dq.peekFirst()).append("\n");
				break;
			case "back":
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}
				sb.append(dq.peekLast()).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
}
