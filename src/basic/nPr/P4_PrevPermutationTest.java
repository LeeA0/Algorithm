package basic.nPr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author THKim
 *
 */
// nPr : nPn에서 n을 r로 보면 똑같다.
public class P4_PrevPermutationTest {

	// 1,2,3
	// 3P2 = 3!/1!= 6
	// 1,2,3
	// 3P3 = 3!
	static int N, R;
	static int[] input, numbers;
	static int totalCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		//Arrays.sort(input);

		do {
			// 첫 순열 출력 필수!!!
			System.out.println(Arrays.toString(input));
		} while (prevPermutation(input));
	}

	private static boolean prevPermutation(int[] input) {
		// step1. 골짜기 찾기
		int i = N - 1;
		while (i > 0 && input[i - 1] <= input[i])
			--i;
		if (i == 0)
			return false; // 마지막 순열의 상태이면 다음 순열 없음

		// step2. i-1위치와 교환할 다음 단계 작은 수 뒷쪽에서 찾기
		int j = N - 1;
		while (i<=j && input[i - 1] <= input[j])
			--j;

		// step3. i-1위치값과 j위치값 교환
		swap(input, i - 1, j);

		// step4. i위치부터 맨 뒤까지 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(input, i++, k--);
		}

		return true;
	}

	public static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
