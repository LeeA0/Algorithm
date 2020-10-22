package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//SW_초심자의 회문 검사_1989_D2
public class Solution_1989_초심자의회문검사 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringBuilder str = new StringBuilder(br.readLine().trim());
			String str1 = str.toString();
			String str2 = str.reverse().toString();
			//System.out.println(str.toString());
			//System.out.println(str1);
			//System.out.println(str2);
			if(str1.equals(str2)) {
				System.out.println("#"+t+" 1");
			}else {
				System.out.println("#"+t+" 0");
			}
		}
	}
}
