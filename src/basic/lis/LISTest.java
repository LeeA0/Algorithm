package basic.lis;

import java.util.Scanner;

public class LISTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		// 자신을 끝으로 하는 LIS최장길이
		int[] LIS = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		// 모든 요소들의 최대길이
		int max = 0;
		for (int i = 0; i < N; i++) {
			// 자신만으로 LIS 구성했을 때의 길이 1
			LIS[i] = 1;

			// 자신(i)의 앞에 있는 원소들과 비교
			for (int j = 0; j < i; j++) {
				// 앞쪽 원소보다 자신이 큰 경우
				if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			// 현 원소의 LIS값과 전체 최대값하고 비교하여 최대값 갱신
			if (max < LIS[i]) {
				max = LIS[i];
			}
		}
		System.out.println(max);
	}

}
