package programmers.level2;

// Programmers_점프와순간이동_level2
public class Programmers_점프와순간이동 {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}

	/*
	 * n의 bit중 1의 개수를 세는 것과 같았다
	 * Integer.bitCount보다 직접 나누는게 더 빠름
	 */
	public static int solution(int n) {
		int answer = 0;
		// bit를 이용한 방법
//		int size = Integer.toBinaryString(n).length();
//		for (int i = 0; i < size; i++) {
//			if ((n & (1 << i)) != 0) {
//				answer++;
//			}
//		}
		// 2로 나누는 방법
		while (n > 0) {
			if (n % 2 == 1) {
				answer++;
			}
			n /= 2;
		}
		return answer;
	}
}
