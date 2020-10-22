package swea.d1;

import java.util.Scanner;

//SW_홀수만더하기_2072_D1
public class Solution_2072_홀수만더하기 {

	static int T, N = 10;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int[] num = new int[N];
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				num[i]=scan.nextInt();
				if(num[i]%2!=0)
					sum+=num[i];
			}
			System.out.println("#" + t + " " + sum);
		}

	}

}
