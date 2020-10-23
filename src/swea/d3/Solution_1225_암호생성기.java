package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//SW_암호생성기_1225_D3
public class Solution_1225_암호생성기 {
	static int T = 10, N = 8, Ti;
	static int[] pwd;

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= T; t++) {
			Ti = Integer.parseInt(br.readLine());
			pwd = new int[N];
			for (int i = 0; i < N; i++) {
				String temp[] = br.readLine().split(" ");
				
			}
			boolean isEnd = false;
			while (!isEnd) {
				for (int i = 1; i <= 5; i++) {
					int[] temp = new int[N];
					// 1~7까지 temp에 저장
					for (int j = 0; j < N - 1; j++) {
						temp[j] = pwd[j + 1];
					}
					// 0번쨰 배열 값에 1~5감소 후 temp맨 끝에 저장
					temp[N - 1] = pwd[0] - i;
					if (temp[N - 1] < 0)
						temp[N - 1] = 0;
					for (int j = 0; j < N; j++) {
						pwd[j] = temp[j];
					}
					if (pwd[N - 1] == 0) {
						isEnd = true;
						break;
					}
				}
			}
			System.out.print("#" + t);
			for (int i = 0; i < N; i++) {
				System.out.print(" " + pwd[i]);
			}
			System.out.println();
		}
	}
}
