package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Programmers_위장 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] clothes = new String[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			clothes[i][0] = st.nextToken();
			clothes[i][1] = st.nextToken();
		}
		System.out.println(solution(clothes));
	}

	static int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		for (int i = 1; i < (1 << map.size()) - 1; i++) {
			int temp = 1;
			for (int j = 0; j < map.size(); j++) {
				if ((i & (1 << j)) != 0) {
					temp *= map.get(clothes[j][1]);
				}
			}
			
		}

		return answer;
	}
}
