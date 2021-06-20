package programmers;

// Programmers_소수만들기_level1
public class Programmers_소수만들기 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {
		// 3개를 골라 더했을 때 소수가 되는 경우의 개수
		int answer = 0;
		// 주어진 숫자 중 3번의 for문을 이용해 3개를 뽑는다
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					// 더한 숫자가 소수면 카운트
					if (isPrime(sum)) {
						answer++;
					}
				}
			}
		}
		return answer;
	}

	public static boolean isPrime(int num) {
		// 소수는 나눴을 때 1과 자기 자신으로 나누어떨어지는 숫자 이므로
		// 2부터 num-1까지 num을 나눠보았을 때 0으로 나누어 떨어지면 소수가 아니다
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
