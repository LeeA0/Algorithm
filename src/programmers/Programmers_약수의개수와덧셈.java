package programmers;

// Programmers_약수의개수와덧셈_level1
public class Programmers_약수의개수와덧셈 {
	public static void main(String[] args) {
		int left = 24;
		int right = 27;
		System.out.println(solution(left, right));
	}

	public static int solution(int left, int right) {
		int answer = 0;
		// left부터 right의 숫자를 뺴거나 더함
		for (int i = left; i <= right; i++) {
			// 제곱근을 갖는 숫자(4,9,16,25,...)들만 약수의 갯수가 홀수이다
			// 제곱근을 찾는다
			int root = (int) Math.sqrt(i);
			// 제곱근을 제곱하여 그 숫자와 같으면 약수의 개수가 홀수
			if (root * root == i) {
				answer -= i;
			}
			// 아니면 짝수이다
			else {
				answer += i;
			}
		}
		return answer;
	}
}
