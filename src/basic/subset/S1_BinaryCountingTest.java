package basic.subset;

import java.util.Scanner;

public class S1_BinaryCountingTest {
	static int N;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scan.nextInt();
		}
		int caseCount = 1 << N;
		generateSubset(caseCount);
	}

	private static void generateSubset(int caseCount) {
		//공집합을 넣으려면 flag를 0부터, 아니면 1부터
		for (int flag = 1; flag < caseCount - 1; flag++) {
			// flag의 각 비트자리를 확인하여 원소 선택 유/무를 판단
			for (int j = 0; j < N; j++) {
				if ((flag & (1 << j)) != 0) {// 어떤비트든 한비트가 1임 (==1은 안됨)
					System.out.print(numbers[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
