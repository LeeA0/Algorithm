package programmers.level3;

// Programmers_징검다리건너기_level3
public class Programmers_징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 10;
		System.out.println(solution(stones, k));
	}

	static public int solution(int[] stones, int k) {
		int answer = Integer.MAX_VALUE;
		int left = 0;
		int right = Integer.MIN_VALUE;
		for (int i = 0; i < stones.length; i++) {
			right = Math.max(right, stones[i]);
		}
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = getcnt(stones, mid, k);
			if (cnt < k) {
				left = mid + 1;
			} else if (cnt >= k) {
				answer = Math.min(mid, answer); 
				right = mid - 1;
			}
		}

		return answer;
	}

	public static int getcnt(int[] stones, int m, int k) {
		//int max_cnt = 0;
		int cnt = 0;
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] <= m) {
				cnt++;
			} else {
				cnt = 0;
			}
			if (cnt >= k) {
				//max_cnt = Math.max(max_cnt, cnt);
				return cnt;
			}
		}
		//return max_cnt;
		return cnt;
	}

}

//너무 직관적이라 시간초과
//public int solution(int[] stones, int k) {
//    int answer = 0;
//		ArrayList<int[]> num = new ArrayList<>();
//
//		for (int i = 0; i < stones.length; i++) {
//			num.add(new int[] { i, stones[i] });
//		}
//		Collections.sort(num, (o1, o2) -> (o1[1] - o2[1]));
//
//		int i = 0;
//		a: while (i < stones.length) {
//			// 제일 작은 수 부터 차례로 0으로 만든다.
//			answer = num.get(i)[1];
//			while (i < stones.length && num.get(i)[1] == answer) {
//				stones[num.get(i)[0]] = 0;
//				i++;
//			}
//			if (i >= k) {
//				// k개 이상의 0인 돌이 있는지 찾아본다.
//				int cnt = 0;
//				for (int j = 0; j < stones.length; j++) {
//					if (stones[j] == 0) {
//						cnt++;
//					} else {
//						cnt = 0;
//					}
//					if (cnt == k) {
//						break a;
//					}
//				}
//			}
//		}
//		return answer;
// }
