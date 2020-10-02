package basic.lis;

import java.util.Arrays;
import java.util.Scanner;

public class LISTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		// 각 LIS의 길이를 만족하는 맨 끝에오는 최소값을 저장
		int[] LIS = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		// lis 길이
		int size = 0;
		for (int i = 0; i < N; i++) {
			// arr[i] : 탐색 키
			// ==> 찾으면 인덱스, 못찾으면 음수값으로 자신이 삽입될 위치를 반환 : -삽입위치-1
			// ex) 삽입 위치가 0일때 -0-1 = -1이 나온다.
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);

			// 중복값이 없다면 temp:음수값
			temp = Math.abs(temp) - 1; // 삽입위치 환산
			LIS[temp] = arr[i];

			// 맨위에 추가하는 상황
			if (temp == size) {
				++size;
			}
		}
		System.out.println(size);
	}

}
