package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준_나누기_1075_브론즈2
public class BOJ_1075_나누기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		int answer = 0;
		// 100으로 나누고 곱해주면 정수형 타입인 Long의 숫자는 뒤 두자리가 00이 된다.
		N = N/100*100;
		// 뒤 두자리 수를 바꾸면서 N이 나누어떨어지는 가장 작은 수를 구하는 것이므로 0부터 99까지 변경해보며 나누어 떨어지는 수를 찾는다.
		for (int i = 0; i < 100; i++) {
			if(N%F==0) {
				answer=i;
				break;
			}
			N++;
		}
		// String 타입으로 출력해 두자리수를 출력한다.
		System.out.println(String.format("%02d", answer));
	}
}
