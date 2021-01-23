package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_시험감독_13458_브론즈2
public class BOJ_13458_시험감독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 시험장의 개수 입력
		int N = Integer.parseInt(br.readLine().trim());
		// StringTokenizer에 시험장별 응시자 수 저장
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		// B와 C를 입력
		StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());
		
		// 감독관 수를 카운트함
		long count = N;
		for (int i = 0; i < N; i++) {
			// 총감독관이 감시가 가능한 수를 빼서 a에 입력
			int a = Integer.parseInt(st.nextToken())-B;
			// a가 0보다 크면 부감독관이 몇명이 필요한지 계산 후 count에 더해줌
			if (a > 0) {
				count += (int) Math.ceil((double) a / (double) C);
			}
		}

		System.out.println(count);
	}
}

//맨 초기 코드
//public class BOJ_13458_시험감독 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine().trim());
//		int[] A = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine().trim());
//		for (int i = 0; i < N; i++) {
//			A[i] = Integer.parseInt(st.nextToken());
//		}
//		st = new StringTokenizer(br.readLine().trim());
//		int B = Integer.parseInt(st.nextToken());
//		int C = Integer.parseInt(st.nextToken());
//
//		long count = 0;
//		for (int i = 0; i < N; i++) {
//			count++;
//			A[i] -= B;
//			if (A[i] > 0) {
//				count += (int) Math.ceil((double) A[i] / (double) C);
//			}
//		}
//		System.out.println(count);
//	}
//}
