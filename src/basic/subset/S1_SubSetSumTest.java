package basic.subset;

import java.util.Scanner;

public class S1_SubSetSumTest {
	static int N, S, totalCnt;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt(); // 목표점
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println("총 경우의 수: " + totalCnt);

	}

	private static void generateSubset(int cnt) {
		if (cnt == N) {
			// 부분집합의 구성요소의 합
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += input[i];
				}
			}
			if (sum == S) {
				++totalCnt;
				for (int i = 0; i < N; i++) {
					System.out.print(isSelected[i] ? input[i] : "X");
					System.out.print("\t");
				}
				System.out.println();
			}
			return;
		}
		// 부분 집합 구성에 포함
		isSelected[cnt] = true;
		// 다음원소로 넘어감
		generateSubset(cnt + 1);
		// 부분집합 구성에 비포함
		isSelected[cnt] = false;
		// 다음원소로 넘어감
		generateSubset(cnt + 1);
	}

}
