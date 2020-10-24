package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_퍼펙트셔플_3499_D3
public class Solution_3499_퍼펙트셔플 {
	static int T, N;
	// static String[] shuffle;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine().trim());
			// shuffle = new String[N];
			String[] c1, c2;
			c1 = new String[(N + 1) / 2];
			c2 = new String[N / 2];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < c1.length; i++) {
				c1[i] = st.nextToken();
			}
			for (int i = 0; i < c2.length; i++) {
				c2[i] = st.nextToken();
			}
			for (int i = 0; i < N / 2; i++) {
				sb.append(c1[i]).append(" ").append(c2[i]).append(" ");
			}
			if (N % 2 != 0)
				sb.append(c1[N / 2]);
			System.out.println(sb.toString());
		}
	}
}
