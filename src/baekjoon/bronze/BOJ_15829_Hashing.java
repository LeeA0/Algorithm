package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_Hashing_15829_브론즈2
public class BOJ_15829_Hashing {
	static int L;
	final static int r = 31, M = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine().trim());
		char[] temp = br.readLine().trim().toCharArray();

		long hashing = 0;
		long R = 1;
		for (int i = 0; i < L; i++) {
			long a = temp[i] - 'a' + 1;
			hashing = ((hashing % M) + ((a % M) * (R % M)) % M) % M;
			R = (R % M * r % M) % M;
		}
		hashing = hashing % M;
		System.out.println(hashing);
	}
}
