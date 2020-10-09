package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//백준_크로아티아 알파벳_2941_실버5
public class BOJ_2941_크로아티아알파벳 {
	static String[] croatia = { "c=", "c-", "dz=", "d-", "d-", "lj", "nj", "s=", "z=" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		for (String c : croatia) {
			str = str.replace(c, "a");
		}
		System.out.println(str.length());
	}
}

//런타임 에러..//
/*
public class Baekjoon2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().trim().toCharArray();
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'c' && (str[i + 1] == '=' || str[i + 1] == '-')) {
				count++;
				i++;
			} else if (str[i] == 'd' && str[i + 1] == 'z' && str[i + 2] == '=') {
				count++;
				i += 2;
			} else if (str[i] == 'd' && str[i + 1] == '-') {
				count++;
				i++;
			} else if (str[i] == 'l' && str[i + 1] == 'j') {
				count++;
				i++;
			} else if (str[i] == 'n' && str[i + 1] == 'j') {
				count++;
				i++;
			} else if (str[i] == 's' && str[i + 1] == '=') {
				count++;
				i++;
			} else if (str[i] == 'z' && str[i + 1] == '=') {
				count++;
				i++;
			} else {
				count++;
			}
		}
		System.out.println(count);
	}
}*/
