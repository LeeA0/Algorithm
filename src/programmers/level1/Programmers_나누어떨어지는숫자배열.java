package programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

// Programmers_나누어떨어지는숫자배열_level1
public class Programmers_나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		int[] arr = { 3,2,6 };
		int divisor = 10;
		System.out.println(Arrays.toString(solution(arr, divisor)));
	}

	public static int[] solution(int[] arr, int divisor) {
		PriorityQueue<Integer> pque = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				pque.offer(arr[i]);
			}
		}
		if(pque.size()==0) {
			return new int[] {-1};
		}
		int[] answer = new int[pque.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = pque.poll(); 
		}
		return answer;
		// 참고용
		// return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
	}
}
