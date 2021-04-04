package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Programmers_기능개발 {

	public static void main(String[] args) {
		int[] progresses = { 95, 90, 99, 99, 80, 99 };
		int[] speeds = { 1, 1, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		// 앞의 기능이 완성되지 못한다면, 뒤의 기능이 100%가 되어도 배포되지 못한다
		// 이 특성을 이용하기 위해 stack을 사용
		Stack<int[]> stack = new Stack<>();
		for (int i = progresses.length - 1; i >= 0; i--) {
			stack.push(new int[] { i, progresses[i] });
		}

		ArrayList<Integer> answer_list = new ArrayList<>();
		// 날짜를 체크
		int day = 0;
		while (!stack.isEmpty()) {
			// 해당 날짜에 배포 된 기능의 개수를 체크하기 위한 변수
			int deploy = 0;
			// 날짜+1
			day++;
			while (!stack.isEmpty()) {
				int[] first = stack.peek();
				int progress = first[1] + day * speeds[first[0]];
				// 맨 앞의 기능이 완성되었으면 pop하고 배포 기능 수를 +1해준다
				if (progress >= 100) {
					stack.pop();
					deploy++;
				} else {
					// 맨앞의 기능이 완성되지 않았으면 그 다음을 볼 필요가 없으므로 break
					break;
				}
			}
			// 오늘 배포했다면 정답 리스트에 배포된 기능 수를 저장한다
			if (deploy != 0) {
				answer_list.add(deploy);
			}
		}

		int[] answer = new int[answer_list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answer_list.get(i);
		}
		return answer;
	}
}
