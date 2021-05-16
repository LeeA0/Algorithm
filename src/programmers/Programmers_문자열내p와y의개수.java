package programmers;

// Programmers_문자열내p와y의개수_level1
public class Programmers_문자열내p와y의개수 {

	public static void main(String[] args) {
		String s = "pPoooyY";
		System.out.println(solution(s));
	}

	static boolean solution(String s) {
		int pNum = 0;
		int yNum = 0;
		// 대소문자 가릴 것 없이 편하게 세기 위해 전부 소문자로 치환
		s = s.toLowerCase();
		// 문자하나하나 보며 p와 y의 개수를 센다
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr == 'p') {
				pNum++;
			}
			if (curr == 'y') {
				yNum++;
			}
		}
		// 개수가 같은지 여부 반환
		return pNum == yNum;
	}
}
