package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

//문제그대로 풀었더니 시간초과난다 -> 반절 잘라서 탐색?
//이분탐색?]
//백준_나무자르기_2805_실버3
public class BOJ_2805_나무자르기 {
	static int N, M, answer;
	static LinkedList<Integer> tree = new LinkedList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 나무입력
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			tree.add(t);
		}
		// 오름차순 정렬
		Collections.sort(tree, (o1, o2) -> Integer.compare(o2, o1));

		// 이분 탐색을 위한 high, low 설정
		int high = tree.get(0);
		int low = 0;
		// low와 high의 위치가 바뀌면 종료
		while (low <= high) {
			// 가운데 찾음
			int cut = (high + low) / 2;

			//cut을 기준으로 자른 나무 수
			long cuttingtree = getCuttingtree(cut);
			System.out.println(cuttingtree);

			// M보다 작으면 더 낮은데서 잘라야함
			//-> 0 ~ cut-1;
			if (cuttingtree < M) {
				high = cut - 1;
			} 
			// M보다 크거나 같으면 정답일 수 있다. 이 중에 제일 높은 걸 선택
			// 더 높은 수가 정답일 수 있으니 cut+1 ~ max 범위로 재탐색
			else {
				answer = Math.max(answer, cut);
				low = cut + 1;
			}
		}
		System.out.println(answer);
	}

	public static long getCuttingtree(int cut) {
		long cuttingtree = 0;
		for (int t : tree) {
			if (t <= cut) {
				break;
			}
			cuttingtree += t - cut;
		}
		return cuttingtree;
	}
}
