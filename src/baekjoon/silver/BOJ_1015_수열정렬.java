package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준_수열정렬_1015_실버4
public class BOJ_1015_수열정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Comparator<int[]> comparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		};
		PriorityQueue<int[]> A = new PriorityQueue<>(comparator);

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// A = 2 3 1     1 2 3
		// i = 0 1 2  => 2 0 1
		for (int i = 0; i < N; i++) {
			// A배열을 인덱스와 함께 우선순위큐에 집어 넣어 오름차순으로 정렬한다
			A.offer(new int[] { Integer.parseInt(st.nextToken()), i });
		}

		PriorityQueue<int[]> P = new PriorityQueue<>(comparator);
		
		// A    = 1 2 3
		// i    = 2 0 1     0 1 2
		// P[i] = 0 1 2  => 1 2 0
		for (int i = 0; i < N; i++) {
			// A배열의 인덱스와 B배열의 인덱스를 우선순위 큐에 집어 넣어 A배열의 인덱스를 기준으로 오름차순으로 정렬한다
			// 여기서 A배열의 인덱스는 P배열의 인덱스와 같다
			P.offer(new int[] { A.poll()[1], i });
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(P.poll()[1]).append(" ");
		}
		System.out.println(sb);
	}
}
