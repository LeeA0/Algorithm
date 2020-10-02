package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준_줄세우기_2605_브론즈2
public class BOJ_2605_줄세우기{
	static int N;
	static int[] number;
	static LinkedList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		list = new LinkedList<Integer>();
		
		//뽑은 숫자의 위치에 넣어준다.
		for (int i = 0; i < N; i++) {
			int length = list.size();
			list.add(length - number[i], i + 1);
		}

		for (int l : list) {
			System.out.print(l + " ");
		}
		System.out.println();
	}
}
