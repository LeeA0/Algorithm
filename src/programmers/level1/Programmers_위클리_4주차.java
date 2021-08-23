package programmers.level1;

import java.util.HashMap;

public class Programmers_위클리_4주차 {
	public static void main(String[] args) {
		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };
		String[] languages = { "JAVA", "JAVASCRIPT" };
		int[] preference = { 7, 6 };
		System.out.println(solution(table, languages, preference));
	}

	public static String solution(String[] table, String[] languages, int[] preference) {
		// 개발자의 선호도를 빠르게 체크할 수 있도록 HashMap에 저장
		HashMap<String, Integer> preLan = new HashMap<String, Integer>();
		for (int i = 0; i < languages.length; i++) {
			preLan.put(languages[i], preference[i]);
		}
		// 가장 높은 점수와 가장 높은 점수를 가진 언어를 저장하는 변수
		String maxLan = "";
		int max = 0;
		// 직군마다 점수를 계산
		for (int i = 0; i < table.length; i++) {
			String[] lan = table[i].split(" ");
			int score = 0;
			for (int j = 1; j < lan.length; j++) {
				if (preLan.containsKey(lan[j])) {
					// 점수 = 선호도*직업군언어점수
					// 직업군 언어접수는 5,4,3,2,1의 순서로 있으므로 6에서 인덱스를 뻄
					score += preLan.get(lan[j]) * (6 - j);
				}
			}
			// 현재 직군이 이때까지 구한 점수 중에 제일 높으면 교체
			if (score > max) {
				max = score;
				maxLan = lan[0];
			}
			// 점수가 같으면 사전 순으로 먼저오는 직군을 선택
			else if (score == max) {
				maxLan = maxLan.compareTo(lan[0]) < 0 ? maxLan : lan[0];
			}
		}
		return maxLan;
	}
}
