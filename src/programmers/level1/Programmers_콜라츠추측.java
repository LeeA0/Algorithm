package programmers.level1;

// Programmers_콜라츠추측_level1
public class Programmers_콜라츠추측 {

	public static void main(String[] args) {
		int num = 626331;
		System.out.println(solution(num));
	}

	public static int solution(int num) {
		int answer = 0;
		long n = num;
		while (n != 1) {
			answer++;
			if (answer > 500) {
				break;
			}
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = n * 3 + 1;
			}
		}
		return answer > 500 ? -1 : answer;
	}
}
