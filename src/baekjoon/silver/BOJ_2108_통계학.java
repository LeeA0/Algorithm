package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// BOJ_2108_통계학_실버4
public class BOJ_2108_통계학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();

		Arrays.sort(numbers);

		HashMap<Integer, Integer> countNum = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
			countNum.put(numbers[i], countNum.getOrDefault(numbers[i], 0) + 1);
		}

		ArrayList<Integer> keys = new ArrayList<>(countNum.keySet());
		Collections.sort(keys, (k1, k2) -> {
			if (countNum.get(k1) == countNum.get(k2)) {
				return Integer.compare(k1, k2);
			}
			return Integer.compare(countNum.get(k2), countNum.get(k1));
		});

		int mode = keys.get(0);
		int countMode = 0;
		for (int key : keys) {
			if (countNum.get(mode) == countNum.get(key)) {
				countMode++;
			} else {
				break;
			}
		}

		if (countMode > 1) {
			mode = keys.get(1);
		}

		System.out.println(Math.round((double) sum / (double) N));
		System.out.println(numbers[N / 2]);
		System.out.println(mode);
		System.out.println(numbers[N - 1] - numbers[0]);
	}
}
