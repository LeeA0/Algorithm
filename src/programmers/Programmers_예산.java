package programmers;

// Programmers_예산_level1
public class Programmers_예산 {

	public static void main(String[] args) {
		int[] d = { 1, 3, 2, 5, 4 };
		int budget = 9;
		System.out.println(solution(d, budget));
	}

	static int answer;

	public static int solution(int[] d, int budget) {
		answer = 0;

		select(0, 0, 0, budget);

		return answer;
	}

	public static void select(int cnt, int num, int sum, int budget) {
		
	}
}
