package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

// BOJ_농구경기_1159_브론즈2
public class BOJ_1159_농구경기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> name = new HashMap<Character, Integer>();
		int N = Integer.parseInt(br.readLine());
		// 알파벳을 키값으로 개수를 셈
		for (int i = 0; i < N; i++) {
			char n = br.readLine().charAt(0);
			name.put(n, name.getOrDefault(n, 0) + 1);
		}
		// 알파벳을 정렬하기 위한 treeset
		TreeSet<Character> overFive = new TreeSet<Character>();
		// hashmap을 순회하면서 같은 알파벳이 5개 이상이면 treeset에 추가
		Iterator<Character> iter = name.keySet().iterator();
		while (iter.hasNext()) {
			char curr = iter.next();
			if (name.get(curr) >= 5) {
				overFive.add(curr);
			}
		}
		// 만약 treeset에 들어있는 알파벳이 0개면 항복을 출력
		if (overFive.size() == 0) {
			System.out.println("PREDAJA");
		}
		// 아니면 알파벳을 순서대로 출력
		else {
			iter = overFive.iterator();
			while (iter.hasNext()) {
				System.out.print(iter.next());
			}
		}
	}
}
