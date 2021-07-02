package programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

// Programmers_실패율_level1
public class Programmers_실패율 {
	public static void main(String[] args) {
		int N = 4;
		int[] stages = {4,4,4,4,4};
		System.out.println(Arrays.toString(solution(N, stages)));
	}

	// 스테이지 별 실패율을 저장하는 객체
	static class FailPercent implements Comparable<FailPercent> {
		// 스테이지
		int idx;
		// 실패율
		float fail;

		public FailPercent(int idx, float fail) {
			this.idx = idx;
			this.fail = fail;
		}

		@Override
		public int compareTo(FailPercent o) {
			// 실패율이 다르면 실패율의 내림차 순으로 정렬한다
			if (this.fail != o.fail) {
				return Float.compare(o.fail, this.fail);
			}
			// 같으면 스테이지 오름차 순으로 정렬한다
			return Integer.compare(this.idx, o.idx);
		}
	}

	public static int[] solution(int N, int[] stages) {
		// 해당 스테이지를 이미 통과했거나 통과하지 않은 사람의 수를 저장하는 배열
		int[] people = new int[N + 1];
		// 해당 스테이지를 통과하지 못한 사람의 수를 저장하는 배열
		int[] fail = new int[N + 1];
		for (int i = 0; i < stages.length; i++) {
			// 숫자가 N+1이면 모든 스테이지를 통과한 사람이므로
			if (stages[i] == N + 1) {
				// 모든 스테이지를 통과했다는 숫자에 +1
				for (int j = 1; j < stages[i]; j++) {
					people[j]++;
				}
			}
			// 아닌 경우
			else {
				// 모든 스테이지를 통과했다는 숫자에 +1
				for (int j = 1; j <= stages[i]; j++) {
					people[j]++;
				}
				// 현재 스테이지는 통과하지 못했으므로 실패에 +1
				fail[stages[i]]++;
			}
		}
		// 실패율대로 정렬하기 위해 PriorityQueue를 선언
		PriorityQueue<FailPercent> pq = new PriorityQueue<>();
		// 전체 스테이지를 순회
		for (int i = 1; i < N + 1; i++) {
			// 실패 횟수가 0이면 0을 저장
			if (fail[i] == 0) {
				pq.offer(new FailPercent(i, 0));
			}
			// 실패 횟수가 0이 아니면 계산해서 저장
			else {
				pq.offer(new FailPercent(i, (float)fail[i] / (float)people[i]));
			}
		}
		int[] answer = new int[N];
		// 실패율 내림차순으로 answer배열에 스테이지 번호를 저장
		for (int i = 0; i < answer.length; i++) {
			answer[i] = pq.poll().idx;
		}

		return answer;
	}
}
