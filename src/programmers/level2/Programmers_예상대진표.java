package programmers.level2;

// Programmers_예상대진표_level2
public class Programmers_예상대진표 {

	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 5;
		System.out.println(solution(n, a, b));
	}

	public static int solution(int n, int a, int b) {
		// 라운드 수를 세는 변수
		int answer = 0;
		// a의 다음 라운드 숫자
		int next_a = a;
		// b의 다음 라운드 숫자
		int next_b = b;
		// 만날때까지 반복한다
		while (true) {
			// 라운드 수를 올리고
			answer++;
			// 다음 라운드의 넘버를 계산한다
			next_a = (next_a + 1) / 2;
			next_b = (next_b + 1) / 2;
			// 다음 라운드에서 만나면 멈춘다
			if (next_a == next_b) {
				break;
			}
		}
		return answer;
		// xor로도 가능..!
		// 3 ->  11(2)
		// 7 -> 111(2)
		// XOR> 100(2) => 3라운드!
	}
}
