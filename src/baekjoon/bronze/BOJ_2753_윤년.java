package baekjoon.bronze;

import java.util.Scanner;

//백준_윤년_2753_브론즈4
public class BOJ_2753_윤년 {
	static int year;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		year = scan.nextInt();
		if(year%400==0) {
			System.out.println("1");
		}else if(year%100==0) {
			System.out.println("0");
		}else if(year%4==0){
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
}
