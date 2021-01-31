package baekjoon.bronze;

import java.util.Arrays;

//백준_셀프넘버_4673_브론즈1
public class BOJ_4673_셀프넘버 {
	public static void main(String[] args) {
		boolean[] num = new boolean[10001];
		Arrays.fill(num, true);
		for (int i = 1; i <= 10000; i++) {
			int sum = i;
			char[] temp = Integer.toString(i).toCharArray();
			for (int j = 0; j < temp.length; j++) {
				sum += temp[j] - '0';
			}
			if (sum <= 10000)
				num[sum] = false;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			if (num[i])
				sb.append(i).append("\n");
		}
		System.out.print(sb);
	}
}