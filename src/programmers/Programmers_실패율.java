package programmers;

import java.util.PriorityQueue;

// Programmers_실패율_level1
public class Programmers_실패율 {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {};
		System.out.println(solution(N, stages));
	}
	
	static class FailPercent implements Comparable<FailPercent>{
		int idx;
		int fail;
		public FailPercent(int idx, int fail) {
			this.idx = idx;
			this.fail = fail;
		}
		
		@Override
		public int compareTo(FailPercent o) {
			if(this.fail!=o.fail) {
				
			}
			return ;
		}
	}

	public static int[] solution(int N, int[] stages) {
		int[] people = new int[N + 1];
		int[] fail = new int[N + 1];
		for (int i = 0; i < stages.length; i++) {
			if (stages[i] == N + 1) {
				for (int j = 1; j < stages[i]; j++) {
					people[j]++;
				}
			} else {
				for (int j = 1; j <= stages[i]; j++) {
					people[j]++;
				}
				fail[stages[i]]++;
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>();
		int[] answer = {};
		return answer;
	}
}
