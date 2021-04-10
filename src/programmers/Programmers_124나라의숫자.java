package programmers;

public class Programmers_124나라의숫자 {

	public static void main(String[] args) {
		int n = 11;
		System.out.println(solution(n));
	}

	public static String solution(int n) {
		// 3의 나머지 0,1,2가 나왔을 때 1,2,4로 치환하기 위한 배열
		int[] oneTwoFour = { 1, 2, 4 };
		// 문자열을 붙이기 위해 선언
		StringBuilder sb = new StringBuilder();
		// n이 0보다 클 때까지 반복
		while (n > 0) {
			// 3진수구하듯이 구한다
			sb.append(oneTwoFour[(n - 1) % 3]);
			n = (n - 1) / 3;
		}
		return sb.reverse().toString();
	}
}
