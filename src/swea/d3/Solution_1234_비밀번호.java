package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//SW_비밀번호_1234_D3
public class Solution_1234_비밀번호 {
	static int N, T = 10;
	static ArrayList<Integer> string;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			string = new ArrayList<Integer>();
			char[] temp = st.nextToken().toCharArray();
			for (int i = 0; i < N; i++) {
				string.add(temp[i] - '0');
			}
			/////// 입력 끝////////
			boolean isend = false;
			while (!isend) {
				int i;
				for (i = 0; i < string.size() - 1; i++) {
					if (string.get(i) == string.get(i + 1)) {
						string.remove(i);
						string.remove(i);// 하나지우면 당겨짐
						break;
					}
				}
				if (i == string.size() - 1) {
					isend = true;
				}
			}
			System.out.print("#" + t + " ");
			for (int i : string) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
