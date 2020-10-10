package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//테스트 케이스
//5 99 -> 7
//50001 100000 -> 2
//50000 99999 -> 2

//백준_숨바꼭질_1697_실버1
public class BOJ_1697_숨바꼭질 {
	static int N, K, t;
	static int[] visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();

		visited = new int[100001];

		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(N);
		t = 0;
		if (N != K) {
			while (!que.isEmpty()) {
				t++;
				int size = que.size();
				for (int i = 0; i < size; i++) {
					int curr = que.poll();

					int nx = curr - 1;
					if (check(nx) && visited[nx] == 0) {
						que.offer(nx);
						visited[nx] = t;
					}
					if (nx == K) {
						break;
					}

					nx = curr + 1;
					if (check(nx) && visited[nx] == 0) {
						que.offer(nx);
						visited[nx] = t;
					}
					if (nx == K) {
						break;
					}

					nx = 2 * curr;
					if (check(nx) && visited[nx] == 0) {
						que.offer(nx);
						visited[nx] = t;
					}
					if (nx == K) {
						break;
					}
				}
			}
		}
		System.out.println(visited[K]);
	}

	public static boolean check(int x) {
		if (x >= 0 && x <= 100000) {
			return true;
		}
		return false;
	}
}
