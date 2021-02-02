package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_명령프롬프트_1032_브론즈1
public class BOJ_1032_명령프롬프트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] files = new String[N];
		
		for (int i = 0; i < N; i++) {
			files[i] = br.readLine();
		}
		
		int fileLen = files[0].length();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < fileLen; i++) {
			boolean flag = true;
			char compare = files[0].charAt(i);
			for (int j = 1; j < N; j++) {
				if (compare != files[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			if(flag)sb.append(compare);
			else sb.append('?');
		}
		
		System.out.print(sb);
	}
}
