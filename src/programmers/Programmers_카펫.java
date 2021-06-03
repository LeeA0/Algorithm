package programmers;

import java.util.Arrays;

// Programmers_카펫_level2
public class Programmers_카펫 {
	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		// 카펫의 가로길이와 세로길이를 더한 값을 구한다
		// 통상적으로 brown을 전부 놓았을 때 각 가로변과 세로변이 겹치는 모서리가 4개이다
		// 이 중 절반만 구하는 것이므로 brown을 2로 나누는 것에 2를 더한다
		int sum = brown / 2 + 2;
		// brown과 yellow를 더하면 카펫의 넓이
		int area = brown + yellow;
		// 가로와 세로를 곱해서 넓이와 같은지 판단하기 위해 모든 가로 경우의 수를 구한다
		// 절반까지만 돌려보면 된다
		// 2,8이나 8,2나 같기 때문
		for (int i = 1; i <= sum / 2; i++) {
			int j = sum - i;
			// 같으면 가로, 세로 반환
			if (i * j == area) {
				answer[0] = j;
				answer[1] = i;
				break;
			}
		}

		return answer;
	}
}
