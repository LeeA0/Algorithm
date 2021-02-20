package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준_막대기_1094_실버5
public class BOJ_1094_막대기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int stick = 64;
		int num = 0;
		
		while (true) {
			// 자른 막대를 붙인 것의 합과 현재 반으로 나눠진 막대의 합이 N보다 작거나 같으면
			if (N >= sum + stick) {
				// 반으로 나눈 막대를 붙인다
				sum += stick;
				// 개수를 +1한다
				num++;
			}
			// 현재 붙인 막대의 길이와 목표길이가 같으면
			if (sum == N) {
				// 멈춘다
				break;
			}
			// 막대를 반으로 나눈다
			stick /= 2;
		}
		System.out.println(num);
	}
}