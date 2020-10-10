package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_2491_수열_실버2
public class BOJ_2491_수열 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		arr = new int[N];

		
		int answer=0;
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				cnt++;
				//어처피 맨처음 입력이므로
				answer=1;
			} else {
				if (arr[i - 1] <= arr[i]) {
					cnt++;
					answer=Math.max(answer, cnt);
				} else {
					// 기본적으로 문자하나의 개수가 되므로 1로 초기화
					cnt = 1;
				}
			}
		}

		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				cnt++;
				answer=Math.max(answer, cnt);
			} else {
				if (arr[i - 1] >= arr[i]) {
					cnt++;
					answer=Math.max(answer, cnt);
				} else {
					cnt = 1;
				}
			}
		}
		
		System.out.println(answer);
	}
}
