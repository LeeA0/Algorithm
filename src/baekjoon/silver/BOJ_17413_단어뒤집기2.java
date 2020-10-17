package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_단어뒤집기2_17413_실버3
public class BOJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().trim().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length;) {
			if (str[i] == '<') {
				sb.append('<');
				i++;
				while (str[i] != '>') {
					sb.append(str[i]);
					i++;
				}
				sb.append('>');
				i++;
			} else {
				StringBuilder temp = new StringBuilder();
				temp.append(str[i]);
				i++;
				while (str.length > i && !(str[i] == ' ' || str[i] == '<')) {
					temp.append(str[i]);
					i++;
				}
				sb.append(temp.reverse());
				if (str.length > i && str[i] == ' ') {
					sb.append(' ');
					i++;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
