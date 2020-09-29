package baekjoon.bronze;

import java.util.Scanner;

//백준_숫자의개수_2577_브론즈2
public class BOJ_2577_숫자의개수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 1;
		for (int i = 0; i < 3; i++) {
			sum *= scan.nextInt();
		}
		// 숫자를 문자열로 변환
		char[] number = Integer.toString(sum).toCharArray();
		// 0~9의 개수를 저장하는 배열
		int[] digit = new int[10];
		
		for (char n : number) {
			digit[n-'0']++;
		}
		
		for(int d : digit) {
			System.out.println(d);
		}
	}

}
