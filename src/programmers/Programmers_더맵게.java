package programmers;

import java.util.PriorityQueue;

// Programmers_더맵게_level2
public class Programmers_더맵게 {
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {
		// 넣으면서 정렬하기위해 priority queue 사용
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// 음식목록을 PQ에 넣는다
		for (int s : scoville) {
			pq.offer(s);
		}
		// 초기화
		int answer = 0;
		// 스코빌 지수가 제일 낮은 음식이 K이상이 될 때까지 반복
		while (pq.peek() < K) {
			// 제일 낮은 음식 뽑기
			int first = pq.poll();
			// 만약 PQ가 비어있으면 K이상 만들 수 없으므로 -1을 저장하고 break
			if (pq.isEmpty()) {
				answer = -1;
				break;
			}
			// 두번째로 낮은 음식 뽑기
			int secont = pq.poll();
			// 계산 후 다시 넣기
			pq.offer(first + secont * 2);
			// 섞은 횟수 증가
			answer++;
		}

		return answer;
	}
}
