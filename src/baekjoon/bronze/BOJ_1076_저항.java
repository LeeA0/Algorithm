package baekjoon.bronze;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1076_저항 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String one = br.readLine();
		String two = br.readLine();
		String three = br.readLine();
		
		System.out.println((findValue(one)*10+findValue(two))*findMul(three)); 
	}
	
	static long findValue(String num) {
		switch (num) {
		case "black":
			return 0;
		case "brown":
			return 1;
		case "red":
			return 2;
		case "orange":
			return 3;
		case "yellow":
			return 4;
		case "green":
			return 5;
		case "blue":
			return 6;
		case "violet":
			return 7;
		case "grey":
			return 8;
		default:
			return 9;
		}
	}
	
	static long findMul(String num) {
		switch (num) {
		case "black":
			return 1;
		case "brown":
			return 10;
		case "red":
			return 100;
		case "orange":
			return 1000;
		case "yellow":
			return 10000;
		case "green":
			return 100000;
		case "blue":
			return 1000000;
		case "violet":
			return 10000000;
		case "grey":
			return 100000000;
		default:
			return 1000000000;
		}
	}
}
