package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준_큐_10845_실버4
public class BOJ_큐_10845 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		// back의 편리한 출력을 위해 deque로 선언
		// deque : 앞 뒤에서 넣고 밸 수 있는 자료구조. 사용하기에 따라 큐와 스택처럼 사용할 수 있다
		Deque<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				que.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(que.isEmpty() ? -1 : que.poll()).append('\n');
				break;
			case "size":
				sb.append(que.size()).append("\n");
				break;
			case "empty":
				sb.append(que.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(que.isEmpty()? -1 : que.getFirst()).append("\n");
				break;
			case "back":
				sb.append(que.isEmpty()? -1 : que.getLast()).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
}
