package programmers.level1;

// Programmers_짝수와홀수_level1
public class Programmers_짝수와홀수 {
	public static void main(String[] args) {
		int num = 3;
		System.out.println(solution(num));
	}

	public static String solution(int num) {
		return num % 2 == 0 ? "Even" : "Odd";
	}
}
