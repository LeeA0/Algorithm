package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

// Programmers_네트워크_level3
public class Programmers_네트워크 {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 0, 1 } };
		System.out.println(solution(n, computers));
	}

	public static int solution(int n, int[][] computers) {
		// 정답을 저장하는 변수
		int answer = 0;

		// 방문여부 체크하는 배열
		boolean[] checked = new boolean[n];
		
		// 0번부터 n-1번까지 방문해본다
		for (int i = 0; i < n; i++) {
			// 방문해보지 않은 곳이면
			if (!checked[i]) {
				// 이 지점을 기준으로 연결된 네트워크를 탐색할 것이므로 +1
				answer++;
				// 방문할 노드를 저장하기 위한 Queue
				Queue<Integer> que = new LinkedList<Integer>();
				// 현재 지점을 que에 저장
				que.offer(i);
				// 현재 지점을 방문했다고 표시
				checked[i]=true;
				// queue가 비어있지 않은 동안
				while(!que.isEmpty()) {
					// 제일 앞에 있는 지점하나를 꺼낸다
					int curr = que.poll();
					// 갈 수 있는 지점이 있는 지 탐색
					for (int j = 0; j < n; j++) {
						// 방문한 적 있거나 연결되어있지 않으면 건너 뜀 
						if(checked[j]||computers[curr][j]==0) {
							continue;
						}
						// queue에 저장하고, 방문 표시를 한 뒤 다음 지점을 탐색한다
						que.offer(j);
						checked[j]=true;
					}
				}
			}
		}

		return answer;
	}
}
