package baekjoon.bronze;

import java.util.Scanner;

//백준_두수비교하기_1330_브론즈4
public class BOJ_1330_두수비교하기 {
	static int A, B;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		B = scan.nextInt();
		
		if(A>B) {
			System.out.println(">");
		}else if(A<B) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}
	}
}
