package programmers.level2;

import java.util.ArrayList;
import java.util.TreeSet;

// 리뉴얼 해보기
// Programmers_소수찾기_level2
public class Programmers_소수찾기 {
	public static void main(String[] args) {
		String numbers = "011";
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
		
		// 비트 연산을 이용해 모든 조합의 경우의 수를 뽑는다
		// ex) 1 2 3
		// => {1},{2},{3},{1,2},{1,3}, ...
		// 숫자으 개수가 3개인 경우 2^3-1만큼 반복
		for (int i = 1; i < 1 << num; i++) {
			// 선택된 숫자를 저장하는 곳. 개수가 정확하지 않으므로 arraylist 사용
			ArrayList<Integer> select = new ArrayList<Integer>();
			// 전체개수만큼 반복해서 플래그(i)가 1인 부분만 select리스트에 저장
			for (int j = 0; j < num; j++) {
				if ((i & (1 << j)) != 0) {
					select.add(number[j]);
				}
			}
			// {1,2}인 경우 12와 21인 경우가 있으므로 순열을 돌려준다
			nPr(0, select, new boolean[select.size()], new int[select.size()]);
		}
		// 소수의 개수를 반환
		return primeSave.size();
	}

	private static void nPr(int cnt, ArrayList<Integer> select, boolean[] isSelect, int[] save) {
		// select의 크기만큼 뽑았으면
		if (cnt == select.size()) {
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
		for (int i = 0; i < select.size(); i++) {
			// 이미 save배열에 위치한 수는 건너뛴다
			if (isSelect[i]) {
				continue;
			}
			// 사용하는 숫자라고 표시
			isSelect[i] = true;
			// save에 선택된 숫자를 저장
			save[cnt] = select.get(i);
			// 다음 숫자를 뽑는다
			nPr(cnt + 1, select, isSelect, save);
			// 사용하지 않는 숫자라고 표시
			isSelect[i] = false;
		}
	}

	private static boolean isPrime(int n) {
		// n이 2보다 작은 0,1의 경우 소수가 아님
		if(n<2) {
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
