package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// Programmers_메뉴리뉴얼_level2
public class Programmers_메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders = { "XYZ", "XWY", "WXA" };
		int[] course = { 2, 3, 4 };
		System.out.println(Arrays.toString(solution(orders, course)));
	}
	// 주문할 수 있는 요리의 조합을 저장할 Hashmap
	private static HashMap<String, Integer> course_dishes;

	public static String[] solution(String[] orders, int[] course) {
		// 코스요리 메뉴를 저장하는 리스트
		PriorityQueue<String> answer_list = new PriorityQueue<String>();
		
		// 요리를 구성하는 단품메뉴들의 개수에 따라 차례로 정답 리스트에 저장한다
		for (int i = 0; i < course.length; i++) {
			// 주문할 수 있는 모든 요리의 조합을 저장하는 hashmap을 구현
			course_dishes = new HashMap<String, Integer>();
			// 손님들이 주문한 단품메뉴 리스트에서 음식 가짓수만큼 뽑은 경우의 수를 저장
			for (String order : orders) {
				nCr(0, 0, i, course[i], new char[course[i]], order.toCharArray());
			}
			// 저장한 경우의 수의 키부분(코스요리)을 배열로 변환
			Object[] keyset = course_dishes.keySet().toArray();
			// 해당 가짓 수의 코스요리가 없으면 넘김
			if (keyset.length == 0) {
				continue;
			}
			// 손님들이 여러번 시킨 코스요리를 우선으로 정렬
			Arrays.sort(keyset, (s1, s2) -> Integer.compare(course_dishes.get(s2), course_dishes.get(s1)));
			// 맨 앞의 코스요리가 손님이 가장 많이 시킨 음식이 되므로 max를 맨 앞의 코스요리를 시킨 횟수로 초기화
			int max_cnt = course_dishes.get(keyset[0]);
			// 가장 많이 시킨 코스요리가 2번 미만 주문된 요리면 다음 가짓수로 넘김
			if (max_cnt < 2) {
				continue;
			}
			// 정렬된 keyset을 반복하여,
			// max값과 같은 key값만 정답 리스트에 저장
			// max값보다 작으면 그 뒤는 볼 필요가 없으므로 조회를 멈춤
			for (Object key : keyset) {
				int cnt = course_dishes.get(key);
				if (max_cnt == cnt) {
					answer_list.offer((String) key);
				} else {
					break;
				}
			}
		}
		// 리스트로 저장한 정답을 배열로 변환
		String[] answer = new String[answer_list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answer_list.poll();
		}
		return answer;
	}

	private static void nCr(int cnt, int start, int count_course, int R, char[] select, char[] order) {
		// R개 만큼 뽑았으면 알파벳 순으로 정렬해서 문자열로 바꿔 <문자열, 해당 문자열이 나온 개수>로 hashmap에 저장
		if (cnt == R) {
			char[] temp = new char[select.length];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = select[i];
			}
			Arrays.sort(temp);
			String dish = new String(temp);
			course_dishes.put(dish, course_dishes.getOrDefault(dish, 0) + 1);
			return;
		}
		for (int i = start; i < order.length; i++) {
			// 해당 문자를 선택하고
			select[cnt] = order[i];
			// 다음으로 넘어간다
			nCr(cnt + 1, i + 1, count_course, R, select, order);
		}
	}
}
