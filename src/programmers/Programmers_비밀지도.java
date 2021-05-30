package programmers;

import java.util.Arrays;

public class Programmers_비밀지도 {

	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = { 46, 33, 33 ,22, 31, 50 };
		int[] arr2 = { 27 ,56, 19, 14, 14, 10 };
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		// 정답을 저장할 배열
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			// or연산을 한 뒤 0은 공백으로, 1은 #으로 변환
			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]).replace("0", " ").replace("1", "#");
			// 만약 앞쪽에 0이어서 생략됬다면 개수만큼 0의 치환 값인 공백을 채워준다
			while (answer[i].length() != n) {
				answer[i] = " " + answer[i];
			}
		}
		return answer;
	}
}
