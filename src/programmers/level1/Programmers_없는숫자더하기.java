package programmers.level1;

public class Programmers_없는숫자더하기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };
		System.out.println(solution(numbers));
	}

	public static int solution(int[] numbers) {
		int answer = 45;
		for (int i = 0; i < numbers.length; i++) {
			answer -= numbers[i];
		}
		return answer;
		// 한줄로 쓰면 이렇게도 가능!
		// return 45-Arrays.stream(numbers).sum();
	}

//	public static int solution(int[] numbers) {
//		boolean[] hasNumber = new boolean[10];
//		for (int i = 0; i < numbers.length; i++) {
//			hasNumber[numbers[i]] = true;
//		}
//
//		int answer = 0;
//		for (int i = 0; i < 10; i++) {
//			if (!hasNumber[i]) {
//				answer += i;
//			}
//		}
//		return answer;
//		
//	}
}
