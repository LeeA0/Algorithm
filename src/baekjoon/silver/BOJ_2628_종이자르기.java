package baekjoon.silver;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//백준_종이자르기_2628_실버5
public class BOJ_2628_종이자르기 {
	static int width, height, N;
	static LinkedList<Integer> garo, sero;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		width = scan.nextInt();
		height = scan.nextInt();
		N = scan.nextInt();

		garo = new LinkedList<Integer>();
		sero = new LinkedList<Integer>();

		// 맨처음과 끝을 저장
		garo.add(0);
		garo.add(height);
		sero.add(0);
		sero.add(width);

		// 색종이 자르기
		for (int i = 0; i < N; i++) {
			int garosero = scan.nextInt();
			int index = scan.nextInt();
			// 가로
			if (garosero == 0) {
				garo.add(index);
			}
			// 세로
			else {
				sero.add(index);
			}
		}

		Collections.sort(garo);
		Collections.sort(sero);

		int max = Integer.MIN_VALUE;
		// 제일 큰 사각형넓이 구하기
		for (int i = 0; i < garo.size() - 1; i++) {
			for (int j = 0; j < sero.size() - 1; j++) {
				int area = (garo.get(i + 1) - garo.get(i)) * (sero.get(j + 1) - sero.get(j));
				max = Math.max(max, area);
			}
		}

		System.out.println(max);
	}
}
