package programmers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

// Programmers_두개뽑아서더하기_level1
public class Programmers_두개뽑아서더하기 {
	public static void main(String[] args) {
		int[] numbers = { 2, 1, 3, 4, 1 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	public static int[] solution(int[] numbers) {
		// 중복없이 순서대로 정렬하기위해 사용
		TreeSet<Integer> list = new TreeSet<>();
		// 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더함
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				list.add(numbers[i] + numbers[j]);
			}
		}
		
		// set을 배열로 옮긴
		int[] answer = new int[list.size()];
		Iterator<Integer> iter = list.iterator();
		int i =0;
		while (iter.hasNext()) {
			answer[i++] = iter.next();
		}

		return answer;
	}
}
