package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_팰림드롬수_1259_브론즈1
public class BOJ_1259_팰린드롬수 {
	static char[] N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			N = br.readLine().trim().toCharArray();
			if (N[0] == '0') {
				break;
			}
			int left = 0;
			int right = N.length - 1;
			boolean can = true;
			while (left <= right) {
				if (N[left] != N[right]) {
					can = false;
					break;
				}
				left++;
				right--;
			}
			System.out.println(can ? "yes" : "no");
		}
	}
}
