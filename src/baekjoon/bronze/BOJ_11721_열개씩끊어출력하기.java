package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_열개씩끊어출력하기_11721_브론즈2
public class BOJ_11721_열개씩끊어출력하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		// 10개씩 끊어 출력할 단어를 입력
		String word = br.readLine();
		// 출력내용을 append할 stringbuilder선언
		StringBuilder sb = new StringBuilder();
		// 10개씩 끊었을 때 총 몇개의 단어가 나오는 지 계산
		int last_index = (int)Math.ceil((double)word.length()/(double)10);
		// 10개씩 끊어서 출력
		for (int i = 0; i < last_index; i++) {
			// i가 마지막이면 현재 index부터 단어의 끝까지 출력
			if(i==last_index-1) {
				sb.append(word.substring(i*10, word.length())).append("\n");
			}
			// i*10부터 (i+1)*10번째 자리 단어까지 출력
			else {
				sb.append(word.substring(i*10, (i+1)*10)).append("\n");
			}
		}
		System.out.print(sb);
	}
}
