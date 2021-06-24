package programmers.level2;

// Programmers_N개의최소공배수_level2
public class Programmers_N개의최소공배수 {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 8, 14 };
		System.out.println(solution(arr));
	}

	/*
	 * 두 수의 최소공배수 구하는 걸 n-1번 반복해주면 됨
	 */
	public static int solution(int[] arr) {
		// 맨 첫번째 원소를 현재 원소로 저장
		int curr = arr[0];
		// 두 번째 원소부터 마지막 원소까지 순서대로 현재 원소와의 최소공배수를 구함
		for (int i = 1; i < arr.length; i++) {
			// curr이 다음 원소보다 크면
			if (curr > arr[i]) {
				// 최대 공약수 = 두 숫자의 곱 / 두 숫자의 최대공약수
				curr = curr * arr[i] / GCD(curr, arr[i]);
			} 
			// curr이 다음 원소보다 작으면
			else {
				curr = curr * arr[i] / GCD(arr[i], curr);
			}
		}
		// 최소공배수 반환
		return curr;
	}

	// 최대공약수를 구함
	public static int GCD(int l, int s) {
		// 유클리드 호제법에 의해 l을 s로 나눴을 때 나머지가 0이면 s가 최대공약수
		if (l % s == 0) {
			return s;
		}
		// 아니면 다음으로 계속 나머지를 구함
		return GCD(s, l % s);
	}
}
