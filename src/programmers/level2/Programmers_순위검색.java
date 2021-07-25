package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

// Programmers_순위검색_level2
public class Programmers_순위검색 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution(info, query)));
	}

	// 방법2. hashmap+binarysearch
	public static int[] solution(String[] info, String[] query) {
		// 조건이 같은 지원자의 점수를 같은 곳에 넣기위한 hashmap
		HashMap<String, ArrayList<Integer>> apply = new HashMap<>();
		int[] answer = new int[query.length];
		for (int i = 0; i < info.length; i++) {
			// 지원자의 정보를 공백을 기준으로 자름
			String[] infoOne = info[i].split(" ");
			// 언어, 직군, 경력, 소울푸드 각 해당하는 조건이나 상관없음(-)에 해당하는 키를 만들어줌
			// => 2^4 = 16
			// ex) java backend junior pizza 150
			// java backend junior pizza
			//  -   backend junior pizza
			// java    -    junior pizza
			// java backend   -    pizza
			// ...
			//  -      -      -    pizza
			//  -      -      -      -
			// => 전부 150 추가
			for (int j = 0; j < 1 << 4; j++) {
				StringBuilder key = new StringBuilder();
				for (int k = 0; k < 4; k++) {
					if ((j & (1 << k)) != 0) {
						key.append(infoOne[k]);
					} else {
						key.append("-");
					}
				}
				int score = Integer.parseInt(infoOne[4]);
				// hashmap에 등록되지 않은 키이면 ArrayList를 새로 생성
				if (apply.get(key.toString()) == null) {
					apply.put(key.toString(), new ArrayList<Integer>());
				}
				// 값 추가
				apply.get(key.toString()).add(score);
			}
		}

		// 각 키 값에 담긴 점수를 정렬
		Iterator<String> iter = apply.keySet().iterator();
		while (iter.hasNext()) {
			Collections.sort(apply.get(iter.next()));
		}

		for (int i = 0; i < query.length; i++) {
			// query에 있는 and를 없애줌
			String queryString = query[i].replaceAll(" and", "");
			// 뒤에서부터 점수인 값의 인덱스를 찾음
			int idx = 0;
			for (int j = queryString.length() - 1; j >= 0; j--) {
				if (queryString.charAt(j) == ' ') {
					idx = j;
					break;
				}
			}
			// 지원자 정보를 키값으로, 점수를 기준 값으로 잡음
			String key = queryString.substring(0, idx).replaceAll(" ", "");
			int score = Integer.parseInt(queryString.substring(idx + 1, queryString.length()));
			
			// key에 해당하는 점수 리스트를 가져옴
			ArrayList<Integer> scores = apply.get(key);
			// null이 아니면 이분 탐색을 이용해 기준점을 찾고 기준 점수 이상인 것의 개수를 구함
			if (scores != null) {
				// 경계를 찾을 때까지 반복
				int l = 0, r = scores.size() - 1;
				while (l <= r) {
					int mid = (l + r) / 2;
					// 중간 값이 기준 값보다 크면 r을 낮춤
					// 같은 경우에도 같은 점수가 아래에 더 있을 수 있으므로  r을 낮춤
					if (scores.get(mid) >= score) {
						r = mid - 1;
					} 
					// 중간 값이 기준 값보다 작으면 l을 높임
					else {
						l = mid + 1;
					}
				}
				// ex) 		1 2 3 4 5 6
				// 		idx|0 1 2 3 4 5
				// -> 기준 값이 3 => 3이상인 점수의 개수 = 6-2 = 4
				answer[i] = scores.size() - l;
			}
		}
		return answer;
	}
	// 방법1. 조건대로 반복해서  찾기 => 시간초과
//	public static int[] solution(String[] info, String[] query) {
//		int[] answer = new int[query.length];
//		String[][] apply = new String[info.length][5];
//		for (int i = 0; i < info.length; i++) {
//			apply[i] = info[i].split(" ");
//		}
//		for (int i = 0; i < query.length; i++) {
//			int num = 0;
//			String[] queryString = query[i].split(" ");
//			for (int j = 0; j < apply.length; j++) {
//				int idx = 0;
//				boolean flag = true;
//				for (int k = 0; k < queryString.length - 1; k += 2) {
//					if (!queryString[k].equals("-") && !apply[j][idx].equals(queryString[k])) {
//						flag = false;
//						break;
//					}
//					idx++;
//				}
//				if (flag && Integer.parseInt(apply[j][idx]) >= Integer.parseInt(queryString[7])) {
//					num++;
//				}
//			}
//			answer[i] = num;
//		}
//		return answer;
//	}
}
