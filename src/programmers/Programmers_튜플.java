package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers_튜플 {

	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		// 맨 앞과 뒤의 괄호를 지우고, },{로 나눠서 저장한다
		String[] tuple = s.substring(2, s.length() - 2).split("\\},\\{");
		// 문자열의 길이 순서대로 정렬
		Arrays.sort(tuple, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});

		// 정답을 저장할 리스트를 선언
		ArrayList<Integer> answerList = new ArrayList<>();
		// 문자열리스트를 반복
		for (String t : tuple) {
			// ,를 기준으로 자름
			String[] tupleElement = t.split(",");
			// answerList에 포함되지 않은 숫자면
			for (String te : tupleElement) {
				if (!answerList.contains(Integer.parseInt(te))) {
					// answerList에 포함
					answerList.add(Integer.parseInt(te));
					break;
				}
			}
		}
		// ArrayList를 int[]로 변경
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}
}
