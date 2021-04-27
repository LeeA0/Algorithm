package programmers;

// Programmers_내적_level1
public class Programmers_내적 {
	public static void main(String[] args) {
		int[] a = { -1, 0, 1 };
		int[] b = { 1, 0, -1 };
		System.out.println(solution(a, b));
	}

	public static int solution(int[] a, int[] b) {
		int answer = 0;
		// 내적을 하기위해 처음부터 끝까지 반복
		for (int i = 0; i < a.length; i++) {
			// 곱해서 더한다
			answer += a[i] * b[i];
		}
		return answer;
	}
}
