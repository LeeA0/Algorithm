package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217_로프 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		} //입력완료
		
		// 오름차순 정렬
		Arrays.sort(rope);
		// 들 수 있는 최대 무게
		int max = 0;
		// 순차적으로 순회하면서 들 수 있는 무게가 낮은 로프부터 차례로 뺀다
		// ex) 10 15 20
		// -> 10+10+10=30
		// -> 10 로프를 뻄
		// -> 15+15=30
		// -> 15 로프를 뺌
		// -> 20
		// => 이 중에 제일 큰 무게는 30
		for (int i = 0; i < rope.length; i++) {
			max = Math.max(max, rope[i] * (N - i));
		}
		System.out.println(max);
	}
}
