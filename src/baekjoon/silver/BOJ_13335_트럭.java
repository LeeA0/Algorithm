package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_트럭_13335_실버1
public class BOJ_13335_트럭 {
	// 트럭 수, 다리의 길이, 다리의 최대 하중
	static int n, w, L;
	// 트럭의 무게를 저장하는 Queue선언
	// Queue를 사용한 이유 : 대기 중인 트럭들에서 하나씩 뽑아서 다리 위로 옮겨줄 것이기 때문에
	static Queue<Integer> weights;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		weights = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			weights.offer(Integer.parseInt(st.nextToken()));
		} // 입력 완료

		System.out.println(move());

	}

	public static int move() {
		// 시간
		int t = 0;
		// 다리위에 있는 트럭들의 다리에서 나가는 시간과 무게를 저장하는 Queue선언
		Queue<int[]> onBridge = new LinkedList<>();
		// 현재 다리에 실린 하중을 계산하는 변수
		int bridge_weight = 0;
		
		// 대기 중인 트럭과 다리 위에 있는 트럭이 없을 때까지 반복
		while (!weights.isEmpty() || !onBridge.isEmpty()) {
			// 시간 증가
			// 초반에 증가 시켜준 이유 : t가 0부터 시작이여서?
			t++;
			// 트럭이 나감과 동시에 대기 중인 트럭이 들어와야하므로 
			// 다리의 실린 체중에서 빠지는 트럭의 무게를 먼저 빼줘야하므로 트럭 빼는 것 부터 수행
			// 다리 위에 트럭이 있고, 현재 시간이 다리 위에 있는 트럭이 다리를 지나는 시간이 됬다면
			if (!onBridge.isEmpty() && onBridge.peek()[0] <= t) {
				// 현재 다리 위에있는 트럭에서 빼주고, 다리에 실린 하중에서 빼준다
				bridge_weight -= onBridge.poll()[1];
			}
			// 대기 중인 트럭이 있고, 다리에 현재 실린 하중과 대기 중인 트럭의 무게가 다리의 최대 하중보다 적은 경우
			if (!weights.isEmpty() && bridge_weight + weights.peek() <= L) {
				// 대기 중인 트럭 중 맨 앞순서의 트럭을 뽑아서
				int weight = weights.poll();
				// 다리를 지나가는 시간과 해당 트럭의 무게를 저장
				onBridge.offer(new int[] { t + w, weight });
				// 다리에 실린 하중에 들어가는 트럭의 무게를 더해준다
				bridge_weight += weight;
			}
		}
		
		// 모든 트럭이 지나간 시간을 반환
		return t;
	}
}
