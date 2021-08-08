package programmers.level2;

// Programmers_최댓값과최솟값_level2;
public class Programmers_최댓값과최솟값 {
	public static void main(String[] args) {
		String s = "1 2 3 4";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		// Integer범위 안의 최댓값과 최솟값으로 초기화
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		// 공백을 기준으로 자름
		String[] number = s.split(" ");
		for (int i = 0; i < number.length; i++) {
			// String을 int로 변환
			int curr = Integer.parseInt(number[i]);
			// 현재와 최솟값을 비교해서 작은 값을 저장
			min = Math.min(min, curr);
			// 현재와 최댓값을 비교해서 큰 값을 저장
			max = Math.max(max, curr);
		}
		return min + " " + max;
	}
}
