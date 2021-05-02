package programmers;

// Programmers_두정수사이의합_level1
public class Programmers_두정수사이의합 {

	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		System.out.println(solution(a, b));
	}

	public static long solution(int a, int b) {
		long answer = 0;
		// a가 b보다 크면 두 개를 바꿈
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		// a부터 b까지 모두 더함
		for (int i = a; i <= b; i++) {
			answer += i;
		}
		return answer;
	}
}
