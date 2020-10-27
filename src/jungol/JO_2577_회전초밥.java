package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//queue이용 성공
//정올_회전초밥(고)_2577
public class JO_2577_회전초밥 {
	// 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
	static int N, d, k, c, max;
	static int[] check;
	static ArrayList<Integer> sushi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		check = new int[d];
		sushi = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			sushi.add(Integer.parseInt(br.readLine().trim()));
		}

		int count = 0;
		max = 0;

		// 초기 값 k개 stack에 저장
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			que.offer(sushi.get(i));
			if (check[sushi.get(i) - 1] == 0) {
				count++;
			}
			// 해당 값이 1개 추가됬다는 뜻
			check[sushi.get(i) - 1]++;
		}

		max = count;

		int i = k;
		while (true) {
			if (max == k + 1) {
				break;
			}

			// 앞의 것 하나 꺼냄
			int pre = que.poll();
			check[pre - 1]--;
			if (check[pre - 1] == 0) {
				count--;
			}

			// sushi에서 하나 받아서 뒤에 넣음
			int next = sushi.get(i);
			que.offer(next);
			if (check[next - 1] == 0) {
				count++;
			}
			check[next - 1]++;

			if (check[c - 1] == 0) {
				max = Math.max(max, count+1);
			}else{
				max = Math.max(max, count);
			}
			
			if (i == k - 2) {
				break;
			}
			i = (i + 1) % N;
		}
		System.out.println(max);
	}
}
