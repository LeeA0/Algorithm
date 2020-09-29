package baekjoon.bronze;

import java.util.Scanner;

//백준_상수_2908_브론즈2
public class BOJ_2908_상수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append(scan.nextInt());
		int n1 = Integer.parseInt(sb.reverse().toString());
		
		sb.delete(0, sb.length());
		sb.append(scan.nextInt());
		int n2 = Integer.parseInt(sb.reverse().toString());
		
		if(n1>n2) {
			System.out.println(n1);
		}else {
			System.out.println(n2);
		}
	}
}
