package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준_암호만들기_1759_골드5
public class BOJ_1759_암호만들기 {
	static int L, C;
	static char[] password;
	static char[] selectPass;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim(), " ");
		password = new char[C];
		selectPass = new char[L];
		for (int i = 0; i < C; i++) {
			password[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(password);

		nCr(0, 0);
	}

	public static void nCr(int cnt, int start) {
		if (cnt == L) {
			StringBuilder sb = new StringBuilder();
			boolean isOK = check();
			if (isOK) {
				for (char s : selectPass) {
					sb.append(s);
				}

				System.out.println(sb.toString());
			}
			return;
		}
		for (int i = start; i < C; i++) {
			selectPass[cnt] = password[i];
			nCr(cnt + 1, i + 1);
		}
	}

	private static boolean check() {
		int vowel = 0;
		int conts = 0;
		for (char s : selectPass) {
			// 모음개수 체크
			if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
				vowel++;
			}
			// 자음개수 체크
			else {
				conts++;
			}
		}
		if (vowel >= 1 && conts >= 2) {
			return true;
		} else {
			return false;
		}
	}
}
