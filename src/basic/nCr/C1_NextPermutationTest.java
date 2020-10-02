package basic.nCr;

import java.util.Scanner;

/**
 * 
 * @author THKim
 *
 */
// nCr : nPn에서 n을 r로 보면 똑같다.
public class C1_NextPermutationTest {
	static int N, R;
	static int[] input, p;
	static int totalCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		p = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		int cnt = 0;
		while (++cnt <= R) {
			p[N - cnt] = 1;
		}

		do {
			for (int i = 0; i < N; i++) {
				if (p[i] == 1) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
		} while (nextPermutation(p));
	}

	private static boolean nextPermutation(int[] numbers) {
		// step1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])// 뒤에서 봤을 때 올라감
			--i;
		if (i == 0)
			return false; // 마지막 순열의 상태이면 다음 순열 없음

		// step2. i-1위치와 교환할 다음 단계 큰 수 뒷쪽에서 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step3. i-1위치값과 j위치값 교환
		swap(numbers, i - 1, j);

		// step4. i위치부터 맨 뒤까지 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;
	}

	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
