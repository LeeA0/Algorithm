package programmers.level1;

import java.util.Arrays;

// Programmers_로또의최고순위와최저순위_level1
public class Programmers_로또의최고순위와최저순위 {

	public static void main(String[] args) {
		int[] lottos = { 0, 0, 0, 0, 0, 0 };
		int[] win_nums = { 38, 19, 20, 40, 15, 25 };
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}
	
	/*
	 * Clean Code에 맞게 리팩토링해봤다!
	 */
	public static int[] solution(int[] lottos, int[] win_nums) {
		// 로또번호가 맞은 개수대로 등수를 매김
		int[] rank = { 6, 6, 5, 4, 3, 2, 1 };
		// 0의 개수를 셈
		int zero_num = 0;
		// 로또 번호 맞은 것의 개수를 셈
		int hit_num = 0;
		for (int lotto : lottos) { // l을 lotto로
			if (lotto == 0) {
				zero_num++;
			} else {
				if (isContainWinNums(win_nums, lotto)) { // contain을 isContain으로
					hit_num++;
				}
			}
		}
		return new int[] { rank[hit_num + zero_num], rank[hit_num] };
	}

	// 해당 번호가 당첨번호에 있는지 확인
	public static boolean isContainWinNums(int[] win_nums, int lotto) {
		for (int win_num : win_nums) {
			if (lotto == win_num) {
				return true;
			}
		}
		return false;
	}

//	public static int[] solution(int[] lottos, int[] win_nums) {
//		// 로또번호가 맞은 개수대로 등수를 매김
//		int[] rank = { 6, 6, 5, 4, 3, 2, 1 };
//		// 0의 개수를 셈
//		int zero_num = 0;
//		// 로또 번호 맞은 것의 개수를 셈
//		int hit_num = 0;
//		for (int l : lottos) {
//			if (l == 0) {
//				zero_num++;
//			} else {
//				if (contain(win_nums, l)) {
//					hit_num++;
//				}
//			}
//		}
//		return new int[] { rank[hit_num + zero_num], rank[hit_num] };
//	}
//
//	// 해당 번호가 당첨번호에 있는지 확인
//	public static boolean contain(int[] win_nums, int l) {
//		for (int w : win_nums) {
//			if (l == w) {
//				return true;
//			}
//		}
//		return false;
//	}
}
