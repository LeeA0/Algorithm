package programmers;

import java.util.TreeSet;

// Programmers_폰켓몬_level1
public class Programmers_폰켓몬 {

	public static void main(String[] args) {
		int[] nums = { 3,3,3,2,2,2};
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {
		// 폰켓몬의 종류를 중복없이 담을 treeset
		TreeSet<Integer> ponkemon = new TreeSet<>();
		// treeset에 담아준다
		for (int num : nums) {
			ponkemon.add(num);
		}
		// 선택할 수 있는 폰켓몬의 개수
		int select = nums.length / 2;
		// 만약 선택할 수 있는 폰켓몬의 개수보다 폰켓몬의 종류가 더 많으면 선택할 수 있는 폰켓몬의 개수를
		// 아니면 폰켓못의 종류를 리턴한다
		return select < ponkemon.size() ? select : ponkemon.size();
	}
}
