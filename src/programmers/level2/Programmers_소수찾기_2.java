package programmers.level2;

import java.util.TreeSet;

// 리뉴얼 해보기
// Programmers_소수찾기_level2
public class Programmers_소수찾기_2 {
	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(solution(numbers));
	}

	// subset+순열
	// 소수를 중복없이 저장하기위해 treeset을 사용
	static TreeSet<Integer> primeSave;

	public static int solution(String numbers) {
		// numbers의 자리수를 저장
		int num = numbers.length();
		// numbers의 숫자들을 분리하여 int배열에 저장
		int[] number = new int[num];
		for (int i = 0; i < num; i++) {
			number[i] = numbers.charAt(i) - '0';
		}
		primeSave = new TreeSet<Integer>();

		for (int i = 1; i <= num; i++) {
			nPr(0, i, new boolean[number.length], new int[i], number);
		}
		// 소수의 개수를 반환
		return primeSave.size();
	}

	private static void nPr(int cnt, int R, boolean[] isSelect, int[] save, int[] number) {
		// select의 크기만큼 뽑았으면
		if (cnt == R) {
			// 숫자로 변환한 뒤
			int n = 0;
			for (int i = 0; i < save.length; i++) {
				n *= 10;
				n += save[i];
			}
			// 소수인지 판별하고 소수면 primeSave에 저장
			if (isPrime(n)) {
				primeSave.add(n);
			}
			return;
		}
		// 0부터 select의 크기까지 반복
		for (int i = 0; i < number.length; i++) {
			// 이미 save배열에 위치한 수는 건너뛴다
			if (isSelect[i]) {
				continue;
			}
			// 사용하는 숫자라고 표시
			isSelect[i] = true;
			// save에 선택된 숫자를 저장
			save[cnt] = number[i];
			// 다음 숫자를 뽑는다
			nPr(cnt + 1, R, isSelect, save, number);
			// 사용하지 않는 숫자라고 표시
			isSelect[i] = false;
		}
	}

	private static boolean isPrime(int n) {
		// n이 2보다 작은 0,1의 경우 소수가 아님
		if (n < 2) {
			return false;
		}
		// 2부터 n의 제곱근까지 나눴을 때 나누어떨어지면 소수가 아님
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		// 나누어떨어지지않으면 소수임
		return true;
	}
}
