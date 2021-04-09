package programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_프린터 {
	public static void main(String[] args) {
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		// 프린터 대기 순서를 저장할 Queue를 선언한다
		// 문제가 선입 선출이므로 Queue를 선언
		// index와 우선순위를 같이 저장하기 위해 int[]로 선언
		Queue<int[]> print_waiting = new LinkedList<>();
		// Queue안에서 제일 우선순위가 큰 수를 찾아 저장한다
		int max = 0;
		// priorites의 값을 Queue로 옮긴다
		for (int i = 0; i < priorities.length; i++) {
			max = Math.max(max, priorities[i]);
			print_waiting.offer(new int[] { i, priorities[i] });
		}
		// 1번째부터 시작하므로 1로 초기화
		int answer = 1;
		// Queue가 비지않은 동안 반복
		while (!print_waiting.isEmpty()) {
			// 현재 가장 앞에있는 원소를 꺼낸다
			int[] curr = print_waiting.poll();
			// 만약 현재 원소가 최대가 아니면 다시 넣는다
			if (curr[1] < getMax(print_waiting.iterator())) {
				print_waiting.offer(curr);
			}
			// 현재 원소가 최대이면서 location과 일치하면 끝낸다
			else if (curr[0] == location) {
				break;
			}
			// 현재 원소가 최대이지만 location과 일치하지 않으면 순서를 올린다
			else {
				answer++;
			}
		}
		return answer;
	}
	// 우선 순위가 제일 높은 값을 찾는다
	public static int getMax(Iterator<int[]> iter) {
		int max = 0;
		while(iter.hasNext()) {
			max = Math.max(max, iter.next()[1]);
		}
		return max;
	}
}
