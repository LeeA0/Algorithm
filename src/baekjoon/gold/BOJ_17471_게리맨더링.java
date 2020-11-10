package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_게리맨더링_17471_골드5
public class BOJ_17471_게리맨더링 {
	static int N, answer;
	static int[] people;
	static boolean[][] adjmatrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		adjmatrix = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int to = Integer.parseInt(st.nextToken());
				adjmatrix[i][to - 1] = true;
			}
		}

		answer = Integer.MAX_VALUE;

		subset(0, new boolean[N]);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}

	private static void subset(int cnt, boolean[] isSelected) {
		if (cnt == N) {
			ArrayList<Integer> A = new ArrayList<Integer>();
			ArrayList<Integer> B = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}

			if (A.size() != 0 && B.size() != 0 && bfs(A) && bfs(B)) {
				// 인구 차 계산
				int a = 0;
				int b = 0;
				
				for (int l : A) {
					a += people[l];
				}
				for (int l : B) {
					b += people[l];
				}
//				System.out.println("============");
//				System.out.println(A);
//				System.out.println(B);
//				System.out.println(a);
//				System.out.println(b);
//				System.out.println("============");
				answer = Math.min(answer, Math.abs(a - b));

			}

			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1, isSelected);
		isSelected[cnt] = false;
		subset(cnt + 1, isSelected);
	}

	private static boolean bfs(ArrayList<Integer> list) {
		boolean[] visited = new boolean[N];
		Queue<Integer> que = new LinkedList<Integer>();
		int start=list.get(0);
		que.offer(start);
		visited[start]=true;
		while(!que.isEmpty()) {
			int curr = que.poll();
			for (int i = 0; i < N; i++) {
				if(list.contains(i)&&!visited[i]&&adjmatrix[curr][i]) {
					visited[i]=true;
					que.offer(i);
				}
			}
		}
		// 전부 연결되어 있는지 체크
		for (int i = 0; i < list.size(); i++) {
			if(!visited[list.get(i)]) {
				return false;
			}
		}
		
		return true;
	}
}
