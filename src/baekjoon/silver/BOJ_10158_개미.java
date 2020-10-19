package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전체탐색은 시간초과가 난다
// 백준_개미_10158_실버5
public class BOJ_10158_개미 {
	static int w, h, p, q, t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim(), " ");
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine().trim());

		// 개미가 t초 동안 p,q의 위치에서 출발하여 w,h를 몇 번 움직였는지 계산한 값
		int x = (p + t) / w;
		int y = (q + t) / h;

		// 도착지점
		int answer_x;
		int answer_y;

		// x가 짝수면 0벽면에서 w벽면으로 이동하는 중이라는 것
		if (x % 2 == 0) {
			answer_x = (p + t) % w;
		}
		// x가 홀수면 w벽면에서 0벽면으로 이동하는 중이라는 것
		else {
			answer_x = w - (p + t) % w;
		}

		// y가 짝수면 0벽면에서 h벽면으로 이동하는 중이라는 것
		if (y % 2 == 0) {
			answer_y = (q + t) % h;
		}
		// y가 홀수면 h벽면에서 0벽면으로 이동하는 중이라는 것
		else {
			answer_y = h - (q + t) % h;
		}

		System.out.println(answer_x + " " + answer_y);
	}
}
