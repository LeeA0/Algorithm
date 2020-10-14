package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_병사배치하기_18353_실버2
public class BOJ_18353_병사배치하기 {
	static int N, length;
	static int[] warrior;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		warrior = new int[N];
		length = 1;
		// 맨 처음 값 넣어줌
		warrior[0] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			int idx = search(a);
			warrior[idx] = a;
			if(idx==length) {
				length++;
			}
		}
		System.out.println(N - length);
	}

	public static int search(int a) {
		int idx = 0;
		int left = 0;
		int right = length;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (warrior[mid] > a) {
				left = mid + 1;
			} else if (warrior[mid] < a) {
				right = mid - 1;
			} else {
				idx = mid;
				break;
			}
		}
		if(left>right) {
			idx = left;
		}else if(left==right) {
			idx = right;
		}
		
		return idx;
	}
}
