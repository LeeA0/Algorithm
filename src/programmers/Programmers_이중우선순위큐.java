package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programmers_이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		System.out.println(Arrays.toString(solution(operations)));
	}

	public static int[] solution(String[] operations) {
		LinkedList<Integer> que = new LinkedList<Integer>();
		for (int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i]);
			switch (st.nextToken()) {
			case "I":
				que.add(Integer.parseInt(st.nextToken()));
				break;
			case "D":
				int sort = Integer.parseInt(st.nextToken());
				// sort가 1이면 오름차순 정렬, -1이면 내림차순으로 정렬한다
				Collections.sort(que, (o1, o2) -> Integer.compare(o1 * sort, o2 * sort));
				if (!que.isEmpty()) {
					// 최댓값 혹은 최솟값을 삭제한다
					que.remove(que.size() - 1);
				}
				break;
			}
		}
		if (que.isEmpty()) {
			return new int[] { 0, 0 };
		} else {
			Collections.sort(que);
			return new int[] { que.get(que.size() - 1), que.get(0) };
		}
	}
}
