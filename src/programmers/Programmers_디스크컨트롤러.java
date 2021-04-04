package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Programmers_디스크컨트롤러_level3
public class Programmers_디스크컨트롤러 {
	public static void main(String[] args) {
		int[][] jobs = {  { 1, 9 },{ 0, 3 }, { 2, 6 } };
		System.out.println(solution(jobs));
	}

	public static int solution(int[][] jobs) {
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		PriorityQueue<Job> pque = new PriorityQueue<>();
		int time = 0;
		int idx = 0;
		int answer = 0;

		while (idx < jobs.length || !pque.isEmpty()) {
			while (idx < jobs.length && time >= jobs[idx][0]) {
				pque.add(new Job(jobs[idx][0], jobs[idx][1]));
				idx++;
			}
			if (!pque.isEmpty()) {
				Job curr = pque.poll();
				time += curr.duration;
				answer += time - curr.start;
			} else {
				time++;
			}
		}

		answer /= jobs.length;

		return answer;
	}

	public static class Job implements Comparable<Job> {
		int start;
		int duration;

		public Job(int start, int duration) {
			super();
			this.start = start;
			this.duration = duration;
		}

		@Override
		public int compareTo(Job o) {
			if (this.duration != o.duration) {
				return Integer.compare(this.duration, o.duration);
			}
			return Integer.compare(this.start, o.start);
		}
	}
}
