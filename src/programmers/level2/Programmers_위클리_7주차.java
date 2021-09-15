package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;

public class Programmers_위클리_7주차 {
	public static void main(String[] args) {
		int[] enter = { 1, 3, 2 };
		int[] leave = { 1, 2, 3 };
		System.out.println(Arrays.toString(solution(enter, leave)));
	}

	// 상반기 라인코테 문제랑 같다!
	public static int[] solution(int[] enter, int[] leave) {
		// 회의실에 입장해 있는 사람
		LinkedList<Integer> inPeople = new LinkedList<Integer>();
		// 입장한 사람 배열 인덱스
		int enterIdx = 0;
		// 떠난 사람 배열 인덱스
		int leaveIdx = 0;
		// 반드시 만난 사람 수를 저장하는 배열
		int[] answer = new int[enter.length];
		// 모든 사람이 나갈 때까지 반복
		while (leaveIdx < leave.length) {
			// 모든 사람이 나가지 않았고, 회의실에 들어온 사람 중 나갈 수 있는 사람이 있을 때
			while (leaveIdx < leave.length && inPeople.contains(leave[leaveIdx])) {
				// 회의실에서 내보냄
				inPeople.remove((Integer) leave[leaveIdx]);
				leaveIdx++;
			}
			// 입장가능한 사람이 남아있으면
			if (enterIdx < enter.length) {
				int enterPerson = enter[enterIdx++];
				// 이미 회의실 안에 사람이 있으면 만났다는 표시
				if (inPeople.size() >= 1) {
					meetPeople(answer, inPeople);
				}
				// 지금 들어온 사람은 회의실 안에 있는 사람 전부를 만남
				answer[enterPerson - 1] = inPeople.size();
				// 지금 들어온 사람도 회의실 안에 있는 사람으로 추가
				inPeople.add(enterPerson);
			}
		}
		return answer;
	}

	public static void meetPeople(int[] meetNum, LinkedList<Integer> inPeople) {
		for (int i = 0; i < inPeople.size(); i++) {
			meetNum[inPeople.get(i) - 1]++;
		}
	}
}
