package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

//SW_염라대왕의 이름 정렬_7701_D4
public class Solution_7701_염라대왕의이름정렬 {
	static int T, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			TreeSet<String> name = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					if (s1.length() == s2.length()) {
						return s1.compareTo(s2);// 사전식으로 비교
					} else {
						return s1.length() - s2.length();
					}
				}
			});
			
			for (int i = 0; i < N; i++) {
				name.add(br.readLine().trim());
			}
			
			System.out.println("#" + t);
			
			for(String n : name) {
				System.out.println(n);
			}
		}
	}
}
