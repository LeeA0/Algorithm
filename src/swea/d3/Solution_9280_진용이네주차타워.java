package swea.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//SW_진용이네주차타워_9280_D3
//9280, Main BOJ 탑
public class Solution_9280_진용이네주차타워 {
	static int T;

	public static class Car {
		int n;
		int g;

		public Car(int n, int g) {
			this.n = n;
			this.g = g;
		}

		public Car() {
		}

		@Override
		public String toString() {
			return "Car [n=" + n + ", g=" + g + "]";
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = scan.nextInt();
			int M = scan.nextInt();
			int[] G = new int[N + 1];// 주차장
			int[] R = new int[N + 1];// 주차공간 당 가격
			int[] W = new int[M + 1];// weight
			int[] C = new int[2 * M + 1];// in+, out-
			int[] TT = new int[N + 1];// 자리당총무게
			Car[] car = new Car[M + 1];
			for (int i = 1; i < R.length; i++) {
				R[i] = scan.nextInt();
			}
			for (int i = 1; i < W.length; i++) {
				W[i] = scan.nextInt();
			}
			for (int i = 1; i < C.length; i++) {
				C[i] = scan.nextInt();
			}
			for (int i = 1; i < car.length; i++) {
				car[i] = new Car(i, W[i]);
			}
			Queue<Integer> que = new LinkedList<Integer>();

			for (int c : C) {
				// 차들어온다
				if (c > 0) {
					que.offer(c);
					for (int i = 1; i < N + 1; i++) {
						if (G[i] == 0) {
							G[i] = que.poll();
							TT[i] += car[G[i]].g;
							break;
						}
					}
				} else if (c < 0) {// 차나간다
					for (int i = 1; i < N + 1; i++) {
						if (G[i] == -c) {
							//대기중인 차량이 있다
							if (!que.isEmpty()) {
								G[i] = que.poll();
								TT[i] += car[G[i]].g;
							}else { //대기중인 차량이 없다
								G[i]=0;
							}
							break;
						}
					}
				}
			}
			int total =0;
			for (int i = 0; i < N+1; i++) {
				total += R[i]*TT[i];
			}
			System.out.println("#"+ t + " " + total);
		}
	}
}
