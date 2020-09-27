package basic.nCr;

import java.util.Arrays;
import java.util.Scanner;

/** nCr */
// 입력받은 N개의 숫자 중 R개를 선택하는 조합
public class C1_CombinationTest {

	private static int N, R;
	private static int[] numbers, input; // 조합 저장 배열, 입력된 숫자 배열

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		R = scan.nextInt();

		numbers = new int[R]; // 0으로 초기화
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = scan.nextInt();
		}

		combination(0, 0);
	}

	// 지정된 자리에 조합수 뽑기
	// cnt : 현재까지 뽑은 조합의 갯수, start : 조합의 시작점으로 시도할 원소 인덱스
	private static void combination(int cnt, int start) {
		if (cnt == R) {
			// 배열의 원소 출력
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 현재 수부터 끝 수까지 시도
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}

}
