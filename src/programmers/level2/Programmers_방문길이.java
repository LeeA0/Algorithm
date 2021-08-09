package programmers.level2;

// Programmers_방문길이_level2
public class Programmers_방문길이 {
	public static void main(String[] args) {
		String dirs = "LLLLRLRLRLL";
		System.out.println(solution(dirs));
	}

	public static int solution(String dirs) {
		// 해당 도로의 방문을 체크하는 배열
		boolean[][] isVisited = new boolean[121][121];
		// 처음 가는 도로의 개수
		int answer = 0;
		// 위치는 정중앙에서 시작한다
		int x = 5;
		int y = 5;
		// 주어진 방향대로 이동
		for (int i = 0; i < dirs.length(); i++) {
			// 이동하는 위치를 저장하기위해 현재 위치로 초기화
			int nx = x;
			int ny = y;
			// 방향에 따라 좌표이동
			switch (dirs.charAt(i)) {
			case 'U':
				nx--;
				break;
			case 'D':
				nx++;
				break;
			case 'R':
				ny++;
				break;
			case 'L':
				ny--;
				break;
			}
			// 이동한 위치가 map을 벗어나면 해당 방향 무시
			if (!(0 <= nx && nx <= 10 && 0 <= ny && ny <= 10)) {
				continue;
			}
			// 이동한 길이 이미 방문한 길인지 확인하기 위해 이동 전 위치와 이동 후 위치를 고유값으로 계산
			int xy = x * 11 + y;
			int nxy = nx * 11 + ny;
			// 방문하지 않은 길이면
			if (!isVisited[xy][nxy]) {
				// 정답 횟수 +1
				answer++;
				// 방향에 상관없으므로 양방향 체크
				isVisited[xy][nxy] = true;
				isVisited[nxy][xy] = true;
			}
			// 현재위치를 이동한 위치로 업데이트
			x = nx;
			y = ny;
		}

		return answer;
	}
}
