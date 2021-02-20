package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준_막대기_1094_실버5
public class BOJ_1094_막대기_using_bitmask {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(Integer.bitCount(N));
	}
}