package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//교수님꺼보다 메모리도 적게 먹고, 시간도 빨라서 기분 좋음 ㅎ
//SW_2383_점심식사시간
public class Solution_2383_점심식사시간 {
	static class Stair {
		int x;
		int y;
		int length;

		public Stair(int x, int y, int length) {
			super();
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}

	static int T, N, answer;
	static boolean[] selectStair;
	static int[][] map;
	static LinkedList<Stair> stairlist;
	static LinkedList<int[]> peoplelist;
	static int[][] peopleDist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			stairlist = new LinkedList<>();
			peoplelist = new LinkedList<int[]>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1) {
						peoplelist.add(new int[] { i, j });
					} else if (num >= 2) {
						stairlist.add(new Stair(i, j, num));
					}
				}
			} // 입력 완료
			answer = Integer.MAX_VALUE;
			// 각 사람이 첫 번째 계단으로 갈 때의 거리와 두 번째 계단으로 갈 때의 거리 계산
			peopleDist = new int[peoplelist.size()][2];
			for (int i = 0; i < peoplelist.size(); i++) {
				peopleDist[i][0] = Math.abs(stairlist.get(0).x - peoplelist.get(i)[0])
						+ Math.abs(stairlist.get(0).y - peoplelist.get(i)[1]) + 1;
				peopleDist[i][1] = Math.abs(stairlist.get(1).x - peoplelist.get(i)[0])
						+ Math.abs(stairlist.get(1).y - peoplelist.get(i)[1]) + 1;
			}

			selectStair = new boolean[peoplelist.size()];
			subset(0);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void subset(int cnt) {
		if (cnt == peoplelist.size()) {
			// 첫번째 계단을 선택한 사람들의 리스트
			PriorityQueue<Integer> aStair = new PriorityQueue<Integer>();
			// 두번째 계단을 선택한 사람들의 리스트
			PriorityQueue<Integer> bStair = new PriorityQueue<Integer>();

			for (int i = 0; i < peoplelist.size(); i++) {
				// 첫번째 계단에 저장
				if (selectStair[i]) {
					aStair.offer(peopleDist[i][0]);
				}
				// 두번째 계단에 저장
				else {
					bStair.offer(peopleDist[i][1]);
				}
			}
			int t = 0;
			LinkedList<Integer> onAStair = new LinkedList<Integer>();
			LinkedList<Integer> onBStair = new LinkedList<Integer>();

			while (!aStair.isEmpty() || !bStair.isEmpty()||!onAStair.isEmpty()||!onBStair.isEmpty()) {
				t++;
				if (answer <= t) {
					return;
				}
				// 이미 다 내려간 사람은 onStair에서 제거
				for (int i = 0; i < onAStair.size(); i++) {
					if (onAStair.get(i) == t) {
						onAStair.remove(i);
						i--;
					}
				}
				for (int i = 0; i < onBStair.size(); i++) {
					if (onBStair.get(i) == t) {
						onBStair.remove(i);
						i--;
					}
				}

				// 계단 내려간다
				while (!aStair.isEmpty()) {
					if (aStair.peek() <= t && onAStair.size() < 3) {
							aStair.poll();
							onAStair.add(stairlist.get(0).length + t);
					}else {
						break;
					}
				}
				while (!bStair.isEmpty()) {
					if (bStair.peek() <= t && onBStair.size() < 3) {
							bStair.poll();
							onBStair.add(stairlist.get(1).length + t);
					}else {
						break;
					}
				}
			}
			answer = Math.min(answer, t);

			return;
		}
		selectStair[cnt] = true;
		subset(cnt + 1);
		selectStair[cnt] = false;
		subset(cnt + 1);
	}
}
