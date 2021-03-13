package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준_1110_더하기사이클_브론즈1
public class BOJ_1110_더하기사이클 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 숫자 N
		int N = Integer.parseInt(br.readLine());
		// 다음 숫자 연산을 위해 next에 N을 넣는다
		int next = N;
		// 사이클 카운트
		int cnt = 0;
		while (true) {
			// 다음 숫자 계산 할 것이므로 사이클+1
			cnt++;
			// 현재 숫자가 들어간 next의 일의 자리와 십의자리 숫자를 각각 넣어준다
			int next_one = next % 10;
			int next_ten = next / 10;
			// 일의 자리와 십의 자리 숫자를 더해준다
			int sum = next_one + next_ten;
			// 현재숫자의 일의 자리를 왼쪽에, 더한값의 일의자리 숫자를 오른쪽에 배치하여 다음 숫자를 만든다
			next = next_one * 10 + sum % 10;
			// 다음 숫자가 초기 숫자와 같으면 break
			if (N == next) {
				break;
			}
		}
		// 사이클의 길이 출력
		System.out.println(cnt);
	}
}
