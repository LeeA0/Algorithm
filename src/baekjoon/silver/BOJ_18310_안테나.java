package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/* 집이 있는 곳 중에서 안테나를 설치 할 수 있으므로,
 * 집들 중 가운데에 위치한 집에 안테나를 설치하는 것이 최소가 된다. */

//백준_안테나_18310_실버3
public class BOJ_18310_안테나 {
	static int N;
	static int[] home;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		home = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(home);
		int goal = N / 2;
		if(N%2==1) {
			goal++;
		}
		int left_home = 0;
		int i = 0;
		while(left_home < goal) {
			left_home++;
			i++;
		}
		System.out.println(home[i-1]);
	}
}
