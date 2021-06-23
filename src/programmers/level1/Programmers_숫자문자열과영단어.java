package programmers.level1;

import java.util.HashMap;

// Programmers_숫자문자열과영단어_level1
public class Programmers_숫자문자열과영단어 {
	public static void main(String[] args) {
		String s = "one4seveneight";
		System.out.println(solution(s));
	}

	// 방법 1 : 최대 2.58ms
//	public static int solution(String s) {
//		String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
//		for (int i = 0; i < number.length; i++) {
//			s = s.replaceAll(number[i], Integer.toString(i));
//		}
//		return Integer.parseInt(s);
//	}
	
	// 방법 2 : 최대 0.16ms
	public static int solution(String s) {
		// 숫자문자가 있는지 빠르게 대조하기위해 hashMap을 사용
		HashMap<String, Integer> numberMap = new HashMap<String, Integer>();
		// HashMap에 값을 편하게 넣기위해 배열 생성
		String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		// HashMap에 숫자문자를 키로, 그에 대응하는 숫자를 값으로 넣음
		for (int i = 0; i < number.length; i++) {
			numberMap.put(number[i], i);
		}
		// 숫자문자를 임시로 저장하기위한 StringBuilder
		StringBuilder tempSb = new StringBuilder();
		// 정답문자를 저장하기위한 StringBuilder
		StringBuilder answerSb = new StringBuilder();
		// s를 탐색
		for (int i = 0; i < s.length(); i++) {
			// 문자가 숫자면 정답 StringBuilder에 저장
			if (Character.isDigit(s.charAt(i))) {
				answerSb.append(s.charAt(i));
			} 
			// 아니면 임시 StringBuilder에 저장한 후 numberMap에서 해당 글자가 있는지 확인한 후
			// 올바른 숫자문자면 값을 변환한 후 정답 StringBuilder에 저장하고 임시 StringBuilder를 초기화
			else {
				tempSb.append(s.charAt(i));
				if (numberMap.get(tempSb.toString()) != null) {
					answerSb.append(numberMap.get(tempSb.toString()));
					tempSb.delete(0, tempSb.length());
				}
			}
		}
		// 문자열을 int형태로 변환하여 반환
		return Integer.parseInt(answerSb.toString());
	}
}
