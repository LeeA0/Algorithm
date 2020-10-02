package basic.nPr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author THKim
 *
 */
// nPr : nPn에서 n을 r로 보면 똑같다.
public class P4_NextPermutationTest {

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
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);

		do {
			
			// 첫 순열 출력 필수!!!
			System.out.println(Arrays.toString(input));
		} while (nextPermutation(input));
	}

	private static void permutation(int cnt, int flag) {
		if (cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; ++i) {
			if ((flag & (1 << i)) != 0)
				continue;
			numbers[cnt] = input[i];
			permutation(cnt + 1, flag | (1 << i));// flag는 그대로, 메소드 호출시 전달되는 flag는 연산된 결과
		}
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
