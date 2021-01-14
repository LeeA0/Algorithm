package baekjoon.silver;

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

		// 덱을 사용
		Deque<String> dq = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			switch (st.nextToken()) {
			// 맨 앞에 넣음
			case "push_front":
				dq.addFirst(st.nextToken());
				break;
			// 맨 뒤에 넣음
			case "push_back":
				dq.addLast(st.nextToken());
				break;
			// 맨 앞에서 뺌
			case "pop_front":
				// deque가 비어있으면 -1을 출력
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} 
				// 그렇지 않으면 맨 앞에서 뺸 정수를 출력
				else {
					sb.append(dq.pollFirst()).append("\n");
				}
				break;
			// 맨 뒤에서 뺌
			case "pop_back":
				// deque가 비어있으면 -1을 출력
				if (dq.isEmpty()) {
					sb.append("-1\n");
				}
				// 그렇지 않으면 맨 뒤에서 뺸 정수를 출력
				else {
					sb.append(dq.pollLast()).append("\n");
				}
				break;
			// deque의 크기
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			// deque가 비어있는지 유무
			case "empty":
				sb.append(dq.isEmpty() ? 1 : 0).append("\n");
				break;
			// deque의 가장 앞에 있는 정수를 출력
			case "front":
				// deque가 비어있으면 -1을 출력
				if (dq.isEmpty()) {
					sb.append("-1\n");
				}
				// 그렇지 않으면 가장 앞에 있는 정수를 출력
				else {
					sb.append(dq.peekFirst()).append("\n");
				}
				break;
			// deque의 가장 뒤에 있는 정수를 출력
			case "back":
				// deque가 비어있으면 -1을 출력
				if (dq.isEmpty()) {
					sb.append("-1\n");
				}
				// 그렇지 않으면 가장 뒤에 있는 정수를 출력
				else {
					sb.append(dq.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.print(sb);
	}
}
