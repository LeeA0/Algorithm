package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// linkedlist는 sort과정에서 느리다..!
// Collection.sort와 Array.sort의 속도차이는 엄청나다..!
// 왜지..?
// 백준_우체국_2141_실버1
public class BOJ_2141_우체국 {
	static class Town implements Comparable<Town> {
		long position;
		long people;

		public Town(long position, long people) {
			super();
			this.position = position;
			this.people = people;
		}

		@Override
		public int compareTo(Town o) {
			return Long.compare(this.position, o.position);
		}
	}

	static int N;
	static Town[] town;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		town = new Town[N];
		double person_mid = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int v = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			town[i] = new Town(v, p);
			person_mid += p;
		}
		Arrays.sort(town);

		person_mid = person_mid / 2;
		// 왼쪽 인원세기
		long person = 0;
		int i = 0;
		// 왼쪽 인원이 인원수 중간값을 넘지 않을 때 까지
		while (person < person_mid) {
			person += town[i].people;
			i++;
			if (i == N) {
				break;
			}
		}
		System.out.println(town[i - 1].position);
	}
}

/*
 * 2 
 * 1 3 
 * 2 3 
 * ----- 1
 * 
 * 2 
 * 1 1 
 * 2 2 
 * ----- 2
 * 
 * 2 
 * 1 1 
 * 2 1 
 * ---- 1
 * 
 * 2 
 * 1 1 
 * 3 1 
 * --- 1
 */