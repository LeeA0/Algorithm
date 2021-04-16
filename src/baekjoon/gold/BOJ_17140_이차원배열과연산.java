package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//백준_17140_이차원배열과연산_골드4
public class BOJ_17140_이차원배열과연산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		// 맨 처음크기인 3X3으로 선언
		int[][] A = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력완료
		// 시간
		int t = 0;
		// 시간이 100초가 넘어가면 break하고 -1을 출력
		while (t <= 100) {
			// A의 길이가 r이나 c보다 작으면 k값과 같은지 체크하지 않고, 연산을 수행
			if(A.length<=r||A[0].length<=c) {
				
			}
			// A[r][c]가 k값을 가지면 연산 중지
			else if (A[r][c] == k) {
				break;
			}

			// 시간이 흐름
			t++;

			// 행의 개수가 열의 개수보다 크거나 같을 때
			if (A.length >= A[0].length) {
				A = R(A);
			}
			// 열의 개수가 행의 개수보다 클 때
			else {
				A = C(A);
			}
		}
		// 시간이 100초 이상이면 -1을 출력, 아니면 시간을 출력
		System.out.println(t == 101 ? -1 : t);
	}

	// R연산
	public static int[][] R(int[][] A) {
		// 늘어나는 행 개수를 감당할 arraylist 선언
		ArrayList<Integer>[] new_A_list = new ArrayList[A.length];

		for (int i = 0; i < A.length; i++) {
			// 숫자의 개수를 셀 hashmap 선언
			HashMap<Integer, Integer> count = new HashMap<>();
			for (int j = 0; j < A[i].length; j++) {
				// 해당 값이 0이 아니면 개수를 세준다
				if (A[i][j] != 0) {
					// 있으면 +1 없으면 기본 값 0에 +1을 해준다
					count.put(A[i][j], count.getOrDefault(A[i][j], 0) + 1);
				}
			}
			// 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬 후, key값과 value값을 순서대로 출력해서 리스트에 저장
			new_A_list[i] = (ArrayList<Integer>) count.entrySet().stream()
					.sorted(new Comparator<Entry<Integer, Integer>>() {
						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							if (count.get(o1.getKey()) != count.get(o2.getKey())) {
								return Integer.compare(count.get(o1.getKey()), count.get(o2.getKey()));
							}
							return Integer.compare(o1.getKey(), o2.getKey());
						}
					}).flatMapToInt(c -> IntStream.of(c.getKey(), c.getValue())).boxed().collect(Collectors.toList());
		}

		// 행 중에 최대 길이
		int max = 0;
		for (int i = 0; i < new_A_list.length; i++) {
			max = Math.max(max, new_A_list[i].size());
		}
		// 새로운 A행렬 생성
		int[][] new_A = new int[A.length][max];
		
		// 행 기준으로 넣기
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < max; j++) {
				// 원소 개수가 100 이상이면 break;
				if(j==100) {
					break;
				}
				// 행의 길이만큼 숫자를 저장하고
				if (j < new_A_list[i].size()) {
					new_A[i][j] = new_A_list[i].get(j);
				}
				// 최대 행 길이까지 남는 공간은 0으로 채움
				else {
					new_A[i][j] = 0;
				}
			}
		}

		return new_A;
	}

	// C연산
	public static int[][] C(int[][] A) {
		// 늘어나는 행 개수를 감당할 arraylist 선언
		ArrayList<Integer>[] new_A_list = new ArrayList[A[0].length];

		for (int i = 0; i < A[0].length; i++) {
			// 숫자의 개수를 셀 hashmap 선언
			HashMap<Integer, Integer> count = new HashMap<>();
			for (int j = 0; j < A.length; j++) {
				// 해당 값이 0이 아니면 개수를 세준다
				if (A[j][i] != 0) {
					// 있으면 +1 없으면 기본 값 0에 +1을 해준다
					count.put(A[j][i], count.getOrDefault(A[j][i], 0) + 1);
				}
			}
			// 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬 후, key값과 value값을 순서대로 출력해서 리스트에 저장
			new_A_list[i] = (ArrayList<Integer>) count.entrySet().stream()
					.sorted(new Comparator<Entry<Integer, Integer>>() {
						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							if (count.get(o1.getKey()) != count.get(o2.getKey())) {
								return Integer.compare(count.get(o1.getKey()), count.get(o2.getKey()));
							}
							return Integer.compare(o1.getKey(), o2.getKey());
						}
					}).flatMapToInt(c -> IntStream.of(c.getKey(), c.getValue())).boxed().collect(Collectors.toList());
		}

		// 열 중에 최대 길이
		int max = 0;
		for (int i = 0; i < new_A_list.length; i++) {
			max = Math.max(max, new_A_list[i].size());
		}
		int[][] new_A = new int[max][A[0].length];

		// 열 기준으로 넣기
		for (int i = 0; i < A[0].length; i++) {
			for (int j = 0; j < max; j++) {
				// 원소 개수가 100 이상이면 break;
				if(j==100) {
					break;
				}
				// 열의 길이만큼 숫자를 저장하고
				if (j < new_A_list[i].size()) {
					new_A[j][i] = new_A_list[i].get(j);
				}
				// 최대 열 길이까지 남는 공간은 0으로 채움
				else {
					new_A[j][i] = 0;
				}
			}
		}

		return new_A;
	}
}
