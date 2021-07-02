package programmers.level1;

import java.util.Arrays;

// Programmers_제일작은수제거하기_level1
public class Programmers_제일작은수제거하기 {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 1 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		// 배열의 길이가 1이면 가장 작은 수를 지웠을 때 빈배열이 되므로 -1로 반환
		if (arr.length == 1) {
			int[] answer = { -1 };
			return answer;
		}
		// 가장 작은 수의 인덱스를 저장하는 변수
		int idx = 0;
		// 가장 작은 수를 저장하는 변수, 처음에는 가장 큰 수로 초기화
		int min = Integer.MAX_VALUE;
		// 배열 전체를 돌며 가장 작은 수를 찾는다
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				idx = i;
			}
		}
		// 가장 작은 수를 지울 것이므로 정답 배열은 arr배열의 길이보다 한 칸 작다
		int[] answer = new int[arr.length - 1];
		// arr배열 인덱스
		int i = 0;
		// answer배열 인덱스
		int j = 0;
		// 제일 작은 수를 제외하고 answer배열에 옮겨닮는다
		while (i < arr.length) {
			if (i != idx) {
				answer[j] = arr[i];
				j++;
			}
			i++;
		}
		return answer;
	}
}
