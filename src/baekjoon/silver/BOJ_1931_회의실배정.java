package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준_회의실배정_1931_실버2
public class BOJ_1931_회의실배정 {
	static class conference implements Comparable<conference> {
		int start;
		int end;

		public conference(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(conference o) {
			if(this.end==o.end) {
				return Integer.compare(this.start, o.start);
			}else {
				return Integer.compare(this.end, o.end);
			}
		}

	}

	static int N, answer;
	static LinkedList<conference> list = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new conference(s, e));
		}
		
		Collections.sort(list);

		answer = 0;
		int time = 0;
		Iterator<conference> iter = list.iterator();
		while(iter.hasNext()) {
			conference c = iter.next();
			if (c.start >= time) {
				time = c.end;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
