package programmers;

// Programmers_2016년_level1
public class Programmers_2016년 {
	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		System.out.println(solution(a, b));
	}

	public static String solution(int a, int b) {
		// FRI부터 시작하는 이유는 1월 1일이 금요일이기 떄문
		String[] week = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
		int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		// 1월 1일 이후로 흐른 날짜를 전부 더해 7로 나누면 해당 날짜의 요일이 나온다.
		int day = b;
		
		for (int i = 0; i < a - 1; i++) {
			day += month[i];
		}
		
		return week[(day - 1) % 7];
	}
}
