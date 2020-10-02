package basic.dp;

import java.util.Scanner;

public class FibonacciTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long[] D = new long[N+1];
		D[0] = 0;
		D[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			D[i]=D[i-1]+D[i-2];
		}
		System.out.println(D[N]);
	}

}
