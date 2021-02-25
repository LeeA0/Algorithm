package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_다리를지나는트럭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bridge_length = Integer.parseInt(br.readLine());
		int weight = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] truck_weights = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			truck_weights[i] = Integer.parseInt(st.nextToken());
		}// 입력끝
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		// 다리를 건너가고있는 트럭을 체크해주기 위해 선언
		// 다리가 선입선출의 구조를 갖고 있기 때문에 Queue를 사용
		Queue<int[]> que = new LinkedList<>();
		// 다리에 진입하려는 트럭의 인덱스
		int i = 0;
		// 다리에 실려있는 무게
		int w = 0;
		// 모든 트럭이 지나갈 때 까지 반복
		while (true) {
			// 시간을 +1해준다
			answer++;
			// 현재 다리를 지나가고 있는 트럭이 있고
			// 트럭이 다리를 지나가는 예정 시간과 현재 시간이 같으면
			if (!que.isEmpty() && que.peek()[1] == answer) {
				// 다리에 실려있는 트럭의 무게를 빼준다
				w -= que.peek()[0];
				// 트럭은 다리를 지나갔다
				que.poll();
			}
			// 다리를 지나가지 않은 트럭이 남아있고
			// 현재 다리에 실려진 무게와 진입할 트럭의 무게가 다리가 견딜 수 있는 무게보다 작거나 같으면
			if (i < truck_weights.length && weight >= truck_weights[i] + w) {
				// 트럭이 다리 위로 올라간다
				// 트럭의 무게와 트럭이 다리를 지나가는 예정시간을 함께 저장
				que.offer(new int[] { truck_weights[i], answer + bridge_length });
				// 다리에 현재 올라가는 트럭의 무게를 실어준다
				w += truck_weights[i];
				// 다음 트럭이 다리 위로 올라올 수 있도록 인덱스 증가
				i++;
			}
			// 다리 위에 어떠한 트럭도 없고
			// 다리 위에 올라갈 트럭이 없다면 시간 측정 끝
			if (que.isEmpty() && i >= truck_weights.length) {
				break;
			}
		}
		return answer;
	}
}
