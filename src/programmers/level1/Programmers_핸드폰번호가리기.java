package programmers.level1;

// Programmers_핸드폰번호가리기_level1
public class Programmers_핸드폰번호가리기 {
	public static void main(String[] args) {
		String phone_number = "7777";
		System.out.println(solution(phone_number));
	}

	public static String solution(String phone_number) {
		// 문자열을 저장할 StringBuilder 선언
		StringBuilder sb = new StringBuilder();
		// 뒷 4자리를 제외한 나머지는 *표시
		for (int i = 0; i < phone_number.length()-4; i++) {
			sb.append("*");
		}
		// 뒷 4자리는 번호로 출력
		for (int i = phone_number.length()-4; i < phone_number.length(); i++) {
			sb.append(phone_number.charAt(i));
		}
		return sb.toString();
	}
}
