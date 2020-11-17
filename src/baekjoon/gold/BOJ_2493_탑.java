package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//백준_탑_2493_골드5
public class BOJ_2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> height = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		// stack에 저장 된 탑의 높이가 push될 탑의 길이보다 작으면 pop
		for (int i = 1; i < N + 1; i++) {
			int val = Integer.parseInt(st.nextToken());
			while (!height.isEmpty() && height.peek() < val) {
				height.pop();
				index.pop();
			}
			//현재 탑의 신호를 수신하는 탑이 없으면 0을 출력
			if (height.empty())
				sb.append(0).append(" ");
			//있으면 제일 근처에 있는 높은 탑의 위치 출력
			else {
				sb.append(index.peek()).append(" ");
			}
			height.push(val);
			index.push(i);
		}
		System.out.println(sb.toString());
	}
}
