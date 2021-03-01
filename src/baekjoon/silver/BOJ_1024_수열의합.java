package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_수열의합_1024_실버2
public class BOJ_1024_수열의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 수열의 합
		int N = Integer.parseInt(st.nextToken());
		// 수열의 최소 길이
		int L = Integer.parseInt(st.nextToken());
		// 1+2+3+...
		int sum = 1;
		// 1부터 sum이 N이 넘지 않을 때까지 +1해줌
		// sum에 더해주기 위한 용도 및 수열 길이 체크
		int i = 1;
		// 수열을 찾았는 지 여부
		boolean find = false;
		// 앞에 0을 넣어줘야 하는지 여부
		boolean hasZero = false;

		// 숫자의 합이 N을 넘지않고, i가 100보다 작거나 같을 때
		while (sum <= N && i <= 100) {
			// 수열 길이가 최소 길이보다 길거나 같고, N에서 기본 베이스(1,2,3,...)의 합을 뺐을 때 i의 배수이면
			if (i >= L && (N - sum) % i == 0) {
				// 조건에 맞는 수열 발견
				find = true;
				break;
			}
			// N과 기본베이스의 합이 같고, 최소길이가 1부족할 때 
			if (i + 1 >= L && N == sum) {
				// 조건에 맞는 수열 발견
				find = true;
				// 맨 앞에 0을 추가
				hasZero = true;
				break;
			}
			// 조건에 맞을 때까지 수열의 길이를 늘린다
			i++;
			// 기본 베이스에 i를 더해준다
			// ex) 1+2+3+4+...+i
			sum += i;
		}
		// 조건에 맞는 수열을 발견했을 때
		if (find) {
			// 수의 시작지점을 계산
			// ex) N = 9, L = 3
			// -> i = 3, sum = 6 -> start = 9-6/3+1 = 2
			int start = ((N - sum) / i) + 1;
			// end = 2+3 = 5 
			int end = start + i;

			StringBuilder sb = new StringBuilder();
			// 제로 패딩이 필요하면 앞에 0추가
			// ex) 1 2 => 0 1 2
			if (hasZero) {
				sb.append("0 ");
			}
			// => 2 3 4 출력
			for (int j = start; j < end; j++) {
				sb.append(j).append(" ");
			}
			// 출력
			System.out.println(sb);
		} else {
			// 길이가 100보다 크거나 조건에 맞는 수열이 없을 때
			System.out.println(-1);
		}
	}
}
