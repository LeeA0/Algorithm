package programmers;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

// Programmers_불량사용자_level3
public class Programmers_불량사용자 {
	public static void main(String[] args) {
		String[] user_id = { "crodoc", "abc123", "fradic", "frodor", "frodoc" };
		String[] banned_id = { "******", "******", "******", "******" };
//		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
//		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		System.out.println(solution(user_id, banned_id));
	}

	// 중복 제거를 위한 TreeSet
	static TreeSet<String> list;

	public static int solution(String[] user_id, String[] banned_id) {
		// 해당 아이디를 이미 넣었는지 체크하기 위한 HashMap
		HashMap<String, Boolean> is_selected = new HashMap<>();
		// 초기화
		for (int i = 0; i < user_id.length; i++) {
			is_selected.put(user_id[i], false);
		}

		// Treeset생성
		list = new TreeSet<>();
		// nCr을 통해 후보 리스트를 뽑늗다.
		nCr(0, is_selected, user_id, banned_id);

		// 리스트의 사이즈를 반환
		return list.size();
	}

	public static void nCr(int cnt, HashMap<String, Boolean> is_selected, String[] user_id, String[] banned_id) {
		// 필요한 갯수만 큼 뽑았으면
		if (cnt == banned_id.length) {
			// 선택된 문자를 순서대로 정렬하기위해 pq선언
			PriorityQueue<String> temp = new PriorityQueue<>();
			for (String uid : user_id) {
				// 선택된 것만 집어넣음
				if (is_selected.get(uid)) {
					temp.offer(uid);
				}
			}
			
			// 순서대로 정렬된 pq를 하나의 문자로 합친다
			StringBuilder sb = new StringBuilder();
			while (!temp.isEmpty()){
				sb.append(temp.poll());
			}
			// 리스트에 추가한다
			list.add(sb.toString());
			return;
		}
		// 0번부터 선택하지 않은 것을 선택한다
		for (int i = 0; i < user_id.length; i++) {
			// 차단 유저 조건에 맞는 유저 아이디이면
			if (check(banned_id[cnt], user_id[i])) {
				// 이미 선택된 유저아이디면 건너뜀
				if (is_selected.get(user_id[i])) {
					continue;
				}
				// 선택
				is_selected.put(user_id[i], true);
				// 다음 차단조건에 맞는 유저를 고른다
				nCr(cnt + 1, is_selected, user_id, banned_id);
				// 선택해제
				is_selected.put(user_id[i], false);
			}
		}

	}

	// 조건에 맞는지 체크
	public static boolean check(String banned_id, String user_id) {
		// 길이가 다르면 조건이 다르다
		if (banned_id.length() != user_id.length()) {
			return false;
		}
		// 만약 *이 아닌데 글자가 다르면 조건에 맞지않다
		for (int i = 0; i < banned_id.length(); i++) {
			if (banned_id.charAt(i) != '*' && banned_id.charAt(i) != user_id.charAt(i)) {
				return false;
			}
		}
		// 모든 조건을 통과했으면 조건에 맞다
		return true;
	}
}

// 답이되지 못하고 화석이 되어버린 코드
//static int answer;
//
//public static int solution(String[] user_id, String[] banned_id) {
//	answer = 0;
//	ArrayList<String>[] banned_id_list = new ArrayList[banned_id.length];
//	for (int i = 0; i < banned_id.length; i++) {
//		banned_id_list[i] = new ArrayList<String>();
//	}
//	for (int i = 0; i < banned_id.length; i++) {
//		for (int j = 0; j < user_id.length; j++) {
//			if (check(banned_id[i], user_id[j])) {
//				banned_id_list[i].add(user_id[j]);
//			}
//		}
//	}
//
//	HashMap<String, Boolean> is_selected = new HashMap<String, Boolean>();
//	for (int i = 0; i < user_id.length; i++) {
//		is_selected.put(user_id[i], false);
//	}
//	HashMap<String, Integer> start = new HashMap<>();
//	for (int i = 0; i < banned_id.length; i++) {
//		start.put(banned_id[i], 0);
//	}
//
//	nCr(0, start, is_selected, banned_id, banned_id_list);
//
//	return answer;
//}
//
//public static void nCr(int cnt, HashMap<String, Integer> start, HashMap<String, Boolean> is_selected,
//		String[] banned_id, ArrayList<String>[] banned_id_list) {
//	if (cnt == banned_id.length) {
//		answer++;
//		return;
//	}
//	ArrayList<String> curr_banned_id = banned_id_list[cnt];
//	for (int i = start.get(banned_id[cnt]); i < curr_banned_id.size(); i++) {
//		if (is_selected.get(curr_banned_id.get(i))) {
//			continue;
//		}
//		is_selected.put(curr_banned_id.get(i), true);
//		int pre = start.get(banned_id[cnt]);
//		start.put(banned_id[cnt], i + 1);
//		nCr(cnt + 1, start, is_selected, banned_id, banned_id_list);
//		is_selected.put(curr_banned_id.get(i), false);
//		start.put(banned_id[cnt], pre);
//	}
//}
//
//public static boolean check(String banned_id, String user_id) {
//	if (banned_id.length() != user_id.length()) {
//		return false;
//	}
//	for (int i = 0; i < banned_id.length(); i++) {
//		if (banned_id.charAt(i) != '*' && banned_id.charAt(i) != user_id.charAt(i)) {
//			return false;
//		}
//	}
//	return true;
//}
