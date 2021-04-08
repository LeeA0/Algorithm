package programmers;

public class Programmers_타겟넘버 {

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	static int answer = 0;

	public static int solution(int[] numbers, int target) {
		// 계산을 시작한다
		acc(0, 0, numbers, target);
		return answer;
	}

	// sum: 지금 단계까지 계산의 결과, idx: 더하는 숫자의 idx
	// numbers: 계산 대상 숫자, target: 목표 계산 결과
	public static void acc(int sum, int idx, int[] numbers, int target) {
		// 모든 숫자를 계산했으면
		if (idx == numbers.length) {
			// 계산결과가 목표와 같으면 +1
			if (sum == target)
				answer++;
			// 다음 진행을 막기위해 리턴
			return;
		}
		// 해당 인덱스 값을 더한다
		acc(sum + numbers[idx], idx + 1, numbers, target);
		// 해당 인덱스 값을 뺸다
		acc(sum - numbers[idx], idx + 1, numbers, target);
	}
}
