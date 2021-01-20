package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_큰수A+B_10757_브론즈5
public class BOJ_10757_큰수A더하기B {
	// 정답을 저장할 배열 선언
	static char[] answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		// 너무 큰 수여서 자바의 자료형으로는 담기지 않는다.
		// 따라서 char배열에 담아 하나씩 처리해준다.
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		// 입력 완료

		// a가 b보다 길이가 길면
		if(a.length>b.length) {
			// a+b으로 인해 정답이 a의 길이보다 길 수 있으므로 +1을 해준다.
			answer = new char[a.length+1];
			// 둘을 더해준다.
			sum(a,b);
		}
		// b가 a보다 길이가 길거나 같으면 
		else {
			// a+b으로 인해 정답이 b의 길이보다 길 수 있으므로 +1을 해준다.
			answer = new char[b.length+1];
			// 둘을 더해준다.
			sum(b,a);
		}
		
		StringBuilder sb = new StringBuilder();
		// 정답 출력
		for (int i = 0; i < answer.length; i++) {
			// 만약 맨 첫 칸이 공백이면 출력하지 않는다.
			if(answer[i]!='\0')sb.append(answer[i]);
		}
		System.out.print(sb);
	}
	
	// large: 길이가 긴 배열
	// small: 길이가 짧은 배열
	private static void sum(char[] large, char[] small) {
		// 자주쓰는 변수 저장
		// 배열은 0번째부터 이므로 길이가 긴 배열의 길이-1을 저장
		// 마찬가지고 길이가 짧은 배열의 길이 -1을 저장
		int largeLen = large.length-1;
		int smallLen = small.length-1;
		// 계산 시에 빼주는 숫자를 변수로 만듬
		int zeroTwo='0'*2;
		
		// 다음 자리수에 1을 더해줄지 말지 결정하는 flag
		boolean sumflag = false;
		// 처음부터 길이가 작은 배열의 끝까지 계산
		for (int i = 0; i < small.length; i++) {
			// A+B
			// 9+5 => '9'-'0'+'5'-'0'
			int temp = large[largeLen-i]+small[smallLen-i] - zeroTwo;
			// 전 배열의 계산에서 flag가 true면 현재 자리수에 1을 더해준다.
			if(sumflag) {
				temp++;
				// 더했으므로 flag를 false처리
				sumflag = false;
			}
			// 계산한 값이 10보다 크면
			// char로 변환 '0'+('9'-'0'+'5'-'0')
			if(temp>=10) {
				// 다음 자리수에 1을 더해주기위해 flag를 true로 변경
				sumflag=true;
				// 계산값에서 10을 뺴준 후 char로 변환한다.
				answer[large.length-i] = (char)(temp-10+'0');
			}else {
				// 계산값을 char로 변환
				answer[large.length-i] = (char)(temp+'0');
			}
		}
		// 길이가 짧은 배열의 길이부터 길이가 긴 배열의 끝까지 계산
		for (int i = small.length; i < large.length; i++) {
			int temp = large[largeLen-i]-'0';
			if(sumflag) {
				temp++;
				sumflag = false;
			}
			if(temp==10) {
				sumflag=true;
				answer[large.length-i] = '0';
			}else {
				answer[large.length-i] = (char)(temp+'0');
			}
		}
		// 만약 마지막자리까지 계산했는데 flag가 true면 answer의 0번째 배열에 1을 넣어준다.
		if(sumflag) {
			answer[0]='1';
		}
	}
}
