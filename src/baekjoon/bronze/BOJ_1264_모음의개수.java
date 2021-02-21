package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준_모음의개수_1264_브론즈2
public class BOJ_1264_모음의개수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			char[] word = br.readLine().toCharArray();
			if(word[0]=='#') {
				break;
			}
			int cnt = 0;
			for (int i = 0; i < word.length; i++) {
				if(word[i]=='a'||word[i]=='e'||word[i]=='i'||word[i]=='o'||word[i]=='u'||word[i]=='A'||word[i]=='E'||word[i]=='I'||word[i]=='O'||word[i]=='U') {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}