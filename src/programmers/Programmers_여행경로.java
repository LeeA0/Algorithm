package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Programmers_여행경로_레벨3
public class Programmers_여행경로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] tickets = new String[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tickets[i][0] = st.nextToken();
			tickets[i][1] = st.nextToken();
		}
		System.out.println(Arrays.toString(solution(tickets)));
	}

	// 정답을 저장할 배열 선언
	static String[] answer;

	static String[] solution(String[][] tickets) {
		// 주어진 항공권은 모두 사용해야하므로 방문하는 공항 수는 초기위치(1)+티켓 수 
		answer = new String[tickets.length + 1];
		// 초기위치는 ICN공항
		answer[0] = "ICN";
		// 깊이 우선 탐색을 한다
		dfs(0, tickets, new boolean[tickets.length]);
		return answer;
	}

	// 티켓의 인덱스와 목표지점을 저장하는 객체
	static class Ticket implements Comparable<Ticket>{
		// 티켓의 인덱스
		int idx;
		// 목표 지점
		String target;

		public Ticket(int idx, String target) {
			this.idx = idx;
			this.target = target;
		}
		@Override
		public int compareTo(Ticket o) {
			// 목표지점을 알파벳 순서로 정렬
			return this.target.compareTo(o.target);
		}
	}

	// 여행경로를 짜기위해 깊이 우선 탐색으로 순회
	// cnt: 방문한 공항 수
	// tickets: 티켓을 담은 배열
	// visited: 티켓을 사용했는지 여부를 저장
	static boolean dfs(int cnt, String[][] tickets, boolean[] visited) {
		// 모든 티켓을 사용하였으면 true로 리턴
		if (cnt == tickets.length) {
			return true;
		}
		// 갈 수 있는 공항을 담는 PriorityQueue 선언
		PriorityQueue<Ticket> pque = new PriorityQueue<>();
		// 전체 티켓리스트를 본다
		for (int i = 0; i < tickets.length; i++) {
			// 아직 사용하지 않았고, 현재 공항과 티켓의 출발지가 같으면
			if (!visited[i] && answer[cnt].equals(tickets[i][0])) {
				// 사용 할 수 있는 티켓의 인덱스와 목적지를 저장
				pque.offer(new Ticket(i, tickets[i][1]));
			}
		}
		// que가 비어있지않으면
		while (!pque.isEmpty()) {
			// 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return하게 하므로
			// 알파벳 순서로 정렬된 사용가능한 티켓 중 우선순위가 높은 티켓을 꺼낸다
			Ticket t = pque.poll();
			// 해당 티켓 사용 체크
			visited[t.idx] = true;
			// 여행경로에 해당 목적지를 추가
			answer[cnt + 1] = t.target;
			// 목적지로 이동한다
			// 만약 모든 티켓을 사용하였다는 표시인 true를 받으면 또 다시 true로 리턴
			if (dfs(cnt + 1, tickets, visited)) {
				return true;
			}
			// 모든 티켓을 사용할 수 있는 경로가 아니면 티켓 사용여부를 초기화 시켜준다
			// 여행경로는 어처피 덧씌워지므로 따로 초기화 시키지않는다
			visited[t.idx] = false;
		}
		// 만약 갈 수 있는 곳이 없으면 false리턴
		return false;
	}
}
