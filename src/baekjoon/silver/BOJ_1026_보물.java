package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준_보물_1026_실버4
public class BOJ_1026_보물 {
	static int N;
	static int[] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		A = new int[N];
		B = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
		StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum=0;
		for (int i = 0; i < N; i++) {
			sum += A[i]*B[N-1-i];
		}
		
		System.out.println(sum);
	}
}
