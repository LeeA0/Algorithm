package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_여우는 어떻게 울지?_9536_실버5
public class BOJ_9536_여우는어떻게울지 {
	static int T;
	static String[] crying;
	static String[] animal;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			crying = new String[100];
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; st.hasMoreTokens(); i++) {
				crying[i] = st.nextToken();
			}
			animal = new String[100];
			int i = 0;
			while (true) {
				String temp = br.readLine().trim();
				if (temp.equals("what does the fox say?")) {
					break;
				}
				animal[i] = temp.split(" ")[2];
				i++;
			}
			for (int j = 0; j < 100; j++) {
				boolean can = true;
				for (int k = 0; animal[k] != null; k++) {
					if (crying[j] == null || animal[k].equals(crying[j])) {
						can = false;
					}
				}
				if (can) {
					System.out.print(crying[j] + " ");
				}
			}
			System.out.println();
		}
	}
}