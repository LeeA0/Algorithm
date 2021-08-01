package programmers.level2;

// Programmers_n진수게임_level2
public class Programmers_n진수게임 {
	public static void main(String[] args) {
		int n = 2;
		int t = 4;
		int m = 2;
		int p = 1;
		System.out.println(solution(n, t, m, p));
	}

	public static String solution(int n, int t, int m, int p) {
		// 전체 숫자를 저장할 StringBuilder
		StringBuilder numberSb = new StringBuilder();
		// 최대 t*m까지 나오므로 StringBuilder의 길이가 t*m이 될 때까지 숫자를 저장
		for (int i = 0; numberSb.length() <= t * m; i++) {
			numberSb.append(Integer.toString(i, n));
		}

		// 정답을 저장할 StringBuilder
		StringBuilder answer = new StringBuilder();
		// numberSb에 저장된 문자를 저장
		String number = numberSb.toString();
		// 해당 차례의 숫자를 answer에 저장
		for (int i = 0; i < t; i++) {
			answer.append(number.charAt(i * m + p - 1));
		}
		// 알파벳의 경우 대문자로 출력하라 했으므로 대문자로 변환
		return answer.toString().toUpperCase();
	}
}
