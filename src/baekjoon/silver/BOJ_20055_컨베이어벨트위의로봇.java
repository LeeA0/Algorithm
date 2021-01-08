package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_컨베이어벨트위의로봇_20055_실버1
public class BOJ_20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 공백으로 나뉘어져 있으므로 StringTokenizer를 통해 나눠줌
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		// StringTokenizer로 나눈 값을 N,K에 하나 씩 넣음
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		// 컨테이너 내구도를 저장하는 배열 선언
		int[] container = new int[2 * N];
		// 상판에 올라오는 로봇 배열
		boolean[] robot = new boolean[N];
		
		// StringTokenizer로 나눈 값을 container배열에 저장
		for (int i = 0; i < 2 * N; i++) {
			container[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		int idx = 0;// 컨테이너 벨트에서 올라가는 위치 인덱스
		
		int stage = 0;
		
		int cnt = 0;// 내구도가 0인 칸의 개수
		while(cnt<K) {
			stage++;
			// 벨트 회전
			// idx-1이 0보다 작으면 음수이므로 배열의 크기만큼 더해줌
			idx = idx-1 < 0?idx-1+2*N : idx-1;
			for (int i = N-2; i >= 0; i--) {
				// 해당 칸에 로봇이 있으면 벨트와 함께 옮겨줌
				if(robot[i]) {
					robot[i]=false;
					robot[i+1]=true;
				}
			}
			// 맨 끝 상판(N-1)번째에 있는 로봇은 무조건 내려감
			robot[N-1]=false;
			// 윗판에 로봇이 올라가거나 이동하면 내구도를 1씩 감소
			for (int i = N-2; i >= 0; i--) {
				// 해당 칸에 로봇이 있고, 다음 칸에 로봇이 없으며, 내구도가 0이 아니면
				if(robot[i]&&!robot[i+1]&&container[(idx+i+1)%(2*N)]>=1) {
					// 다음 칸으로 이동
					robot[i]=false;
					robot[i+1]=true;
					// 이동한 칸의 내구도 1감소
					container[(idx+i+1)%(2*N)]--;
				}
			}
			// 맨 처음 상판(0)번째에 로봇이 없고, 0번째 칸의 내구도가 0이 아니면
			if(!robot[0]&&container[idx]>=1) {
				// 로봇이 올라옴
				robot[0]=true;
				// 올라온 칸의 내구도 1감소
				container[idx]--;
			}
			// cnt 초기화
			cnt=0;
			// 내구도가 0인 칸 개수 세기
			for (int i = 0; i < 2*N; i++) {
				if(container[i]==0)cnt++;
			}
		}
		System.out.println(stage);
	}
}
