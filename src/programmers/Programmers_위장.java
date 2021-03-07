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
		int answer = 1;
		// 종류에 따른 의상 개수 파악을 위한 map선언
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			// 이미 있는 종류이면 +1을, 아니면 1+1=2를 넣어준다
			// default가 1인 이유: 해당 종류를 선택하지 않았을 경우의 수를 추가해준다
			map.put(key, map.getOrDefault(key, 1) + 1);
		}
		// 경우의 수를 모두 곱해준다
		for (Integer num : map.values()) {
			answer *= num;
		}
		// 어떤 옷도 고르지 않았을 때의 경우를 뺴준다
		return answer - 1;
	}
}
