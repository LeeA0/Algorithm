package programmers.level1;

//Programmers_수박수박수박수박수박수_level1
public class Programmers_수박수박수박수박수박수 {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(solution(n));
	}

	public static String solution(int n) {
		// 문자열을 추가할 Stringbuilder선언
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			// 짝수면 수, 홀수면 박을 붙임
			sb.append(i % 2 == 0 ? "수" : "박");
		}
		return sb.toString();
	}
}
