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
	private static HashMap<String, Integer>[] course_dishes;

	public static String[] solution(String[] orders, int[] course) {
		course_dishes = new HashMap[course.length];
		for (int i = 0; i < course_dishes.length; i++) {
			course_dishes[i] = new HashMap<String, Integer>();
		}
		for (int i = 0; i < course.length; i++) {
			for (String order : orders) {
				nCr(0, 0, i, course[i], new char[course[i]], order.toCharArray());
			}
		}
		PriorityQueue<String> answer_list = new PriorityQueue<String>();
		for (HashMap<String, Integer> course_dish : course_dishes) {
			Object[] keyset = course_dish.keySet().toArray();
			if (keyset.length == 0) {
				continue;
			}
			Arrays.sort(keyset, (s1, s2) -> Integer.compare(course_dish.get(s2), course_dish.get(s1)));
			int max_cnt = course_dish.get(keyset[0]);
			if (max_cnt < 2) {
				continue;
			}
			for (Object key : keyset) {
				int cnt = course_dish.get(key);
				if (max_cnt == cnt) {
					answer_list.offer((String) key);
				} else {
					break;
				}
			}
		}
		String[] answer = new String[answer_list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answer_list.poll();
		}
		return answer;
	}

	private static void nCr(int cnt, int start, int count_course, int R, char[] select, char[] order) {
		if (cnt == R) {
			char[] temp = new char[select.length];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = select[i];
			}
			Arrays.sort(temp);
			String dish = new String(temp);
			course_dishes[count_course].put(dish, course_dishes[count_course].getOrDefault(dish, 0) + 1);
			return;
		}
		for (int i = start; i < order.length; i++) {
			select[cnt] = order[i];
			nCr(cnt + 1, i + 1, count_course, R, select, order);
		}
	}
}
