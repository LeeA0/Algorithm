package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;

//상반기 라인코테 문제랑 같다!
public class Programmers_위클리_7주차 {
	public static void main(String[] args) {
		int[] enter = { 1, 3, 2 };
		int[] leave = { 1, 2, 3 };
		System.out.println(Arrays.toString(solution(enter, leave)));
	}

	static LinkedList<Integer> peopleInMeetingRoom;
	static int enterPersonIdx, leavePersonIdx;
	static int[] meetPeopleNum;

	public static int[] solution(int[] enter, int[] leave) {
		peopleInMeetingRoom = new LinkedList<Integer>();
		enterPersonIdx = 0;
		leavePersonIdx = 0;
		meetPeopleNum = new int[enter.length];
		while (!allPeopleLeave(leave)) {
			leavePeople(enter, leave);
			enterPeople(enter, leave);
		}
		return meetPeopleNum;
	}

	public static void enterPeople(int[] enter, int[] leave) {
		if (canEnterPerson(enter)) {
			int enterPerson = enter[enterPersonIdx++];
			if (isPeopleInMeetingRoom()) {
				meetPeople();
			}
			countMeetPerson(enterPerson);
			peopleInMeetingRoom.add(enterPerson);
		}
	}

	public static void countMeetPerson(int enterPerson) {
		// 지금 들어온 사람은 회의실 안에 있는 사람 전부를 만난 것이므로 안에 있는 사람 수 만큼 증가
		meetPeopleNum[enterPerson - 1] = peopleInMeetingRoom.size();
	}

	public static void leavePeople(int[] enter, int[] leave) {
		while (!allPeopleLeave(leave) && canLeavePerson(leave[leavePersonIdx])) {
			peopleInMeetingRoom.remove((Integer) leave[leavePersonIdx]);
			leavePersonIdx++;
		}
	}

	public static boolean isPeopleInMeetingRoom() {
		return peopleInMeetingRoom.size() >= 1;
	}

	public static boolean canEnterPerson(int[] enter) {
		return enterPersonIdx < enter.length;
	}

	public static boolean canLeavePerson(int leavePerson) {
		return peopleInMeetingRoom.contains(leavePerson);
	}

	public static boolean allPeopleLeave(int[] leave) {
		return leavePersonIdx >= leave.length;
	}

	public static void meetPeople() {
		for (int i = 0; i < peopleInMeetingRoom.size(); i++) {
			meetPeopleNum[peopleInMeetingRoom.get(i) - 1]++;
		}
	}
}
