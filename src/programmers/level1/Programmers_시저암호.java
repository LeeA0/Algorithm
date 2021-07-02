package programmers.level1;

// Programmers_시저암호_level1
public class Programmers_시저암호 {
	public static void main(String[] args) {
		String s = "ABC";
		int n = 1;
		System.out.println(solution(s, n));
	}

	public static String solution(String s, int n) {
		// 문자열을 문자배열로 변환
		char[] c = s.toCharArray();
		// 전체 문자배열 조회
		for (int i = 0; i < c.length; i++) {
			// 공백일 때 건너뜀
			if (c[i] == ' ') {
				continue;
			}
			// 아닐 경우 n만큼 이동
			else {
				// 대문자일 때
				if (Character.isUpperCase(c[i])) {
					// A를 기준으로 차이를 구해야하기 때문에 문자에서 기준값 A를 빼고 n만큼 더한 후 
					// A~Z의 개수로 나눈 나머지를 구하고 알파벳으로 돌리기 위해 기준값을 더한다
					c[i] = (char) ((c[i] - 'A' + n) % ('Z' - 'A' + 1) + 'A');
				}
				// 소문자일 때
				else {
					// 위와 같음
					c[i] = (char) ((c[i] - 'a' + n) % ('z' - 'a' + 1)+'a');
				}
			}
		}

		return new String(c);
	}
}
