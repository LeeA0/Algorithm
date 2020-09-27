package basic.nPr;

import java.util.Arrays;
import java.util.Scanner;

/** nPr */
// 입력받은 N개의 숫자 중 R개를 선택하는 순열
public class P2_PermutationInputTest {

	private static int N, R;
	private static int[] numbers, input; // 순열 저장 배열, 입력된 숫자 배열
	private static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		R = scan.nextInt();

		numbers = new int[R]; // 0으로 초기화
		isSelected = new boolean[N]; // false로 초기화
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = scan.nextInt();
		}

		permutation(0);
	}

	// 지정된 자리에 순열 뽑기
	private static void permutation(int cnt) { // cnt: 현재까지 뽑은 순열의 갯수
		if (cnt == R) {
			// 배열의 원소 출력
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			// 중복 확인
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i];// 해당숫자 사용
			isSelected[i] = true; // 해당 숫자의 위치로 사용 처리

			permutation(cnt + 1); // 다음 자리 순열 뽑기

			isSelected[i] = false;
		}
	}

}
