package programmers;

public class Programmers_체육복 {

	public static void main(String[] args) {
		int n = 3;
		int[] lost = { 3, 1 };
		int[] reserve = {2};
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		boolean[] lostCloth = new boolean[n];

		for (int i = 0; i < lost.length; i++) {
			lostCloth[lost[i] - 1] = true;
		}

		for (int i = 0; i < reserve.length; i++) {
			int curr = reserve[i] - 1;
			if (lostCloth[curr]) {
				lostCloth[curr] = false;
			} else if (curr != 0 && lostCloth[curr - 1]) {
				lostCloth[curr - 1] = false;
			} else if (curr != reserve.length - 1 && lostCloth[curr + 1]) {
				lostCloth[curr + 1] = false;
			}
		}

		int answer = 0;

		for (int i = 0; i < lostCloth.length; i++) {
			if (!lostCloth[i])
				answer++;
		}

		return answer;
	}
}
