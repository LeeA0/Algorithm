package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_이상한곱셈_1225_브론즈2
public class BOJ_1225_이상한곱셈 {
	// ex)121*34
	// 1*3 + 1*4 + 2*3 + 2*4 + 1*3 + 1*4 = 28
	// = (1+2+1)(3+4)
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		// 위의 공식에 따라 계산해주기위해 자리수 별로 나눠서 받는다.
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		// 입력완료 
		 
		// 각 자리수별 합을 저장하는 변수
		long sumA = 0;
		long sumB = 0;
		// A의 자리수들을 합한다.
		for (int i = 0; i < a.length; i++) {
			sumA+=(a[i]-'0');
		}
		// B의 자리스들을 합한다.
		for (int i = 0; i < b.length; i++) {
			sumB+=(b[i]-'0');
		}
		// sumA와 sumB를 곱해서 계산값을 구한다.
		System.out.println(sumA*sumB);
	}
}
