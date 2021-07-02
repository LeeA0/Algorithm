package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

// Programmers_같은숫자는싫어_level1
public class Programmers_같은숫자는싫어 {
	public static void main(String[] args) {
		int[] arr = { 4, 4, 4, 3, 3 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		// 연속되지않은 숫자들을 저장할 리스트 선언
		ArrayList<Integer> array = new ArrayList<>();
		// arr를 처음부터 끝까지 돌려 맨 나중에 저장한 원소와 지금 저장하려는 원소가 같지않으면 arraylist에 추가
		for (int a : arr) {
			if (array.size() == 0 || array.get(array.size() - 1) != a) {
				array.add(a);
			}
		}

		// list를 array로 변환
		int[] answer = new int[array.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = array.get(i);
		}

		return answer;
	}
}
