package programmers.level3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// Programmers_위클리_3주차_level3
public class Programmers_위클리_3주차 {
	public static void main(String[] args) {
		int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };
		int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };
		System.out.println(solution(game_board, table));
	}

	// block 1개의 좌표를 전부 저장한다
	static class Block {
		LinkedList<int[]> xy;

		public Block() {
			this.xy = new LinkedList<int[]>();
		}

		public void add(int[] a) {
			this.xy.add(a);
		}

		public int[] get(int i) {
			return this.xy.get(i);
		}

		public int size() {
			return this.xy.size();
		}
	}

	public static int solution(int[][] game_board, int[][] table) {
		// 빈 공간 리스트
		LinkedList<Block> blankList = new LinkedList<>();
		// 몇번째 블록인지 카운트할 변수
		int cnt = 0;
		// 게임 보드를 조회하며 빈 공간을 찾아 리스트에 저장한다
		for (int i = 0; i < game_board.length; i++) {
			for (int j = 0; j < game_board[i].length; j++) {
				if (game_board[i][j] == 0) {
					findBlock(i, j, cnt, 1, game_board, blankList);
					cnt++;
				}
			}
		}

		// 블럭 리스트
		LinkedList<Block> blockList = new LinkedList<>();
		// 몇번째 블록인지 카운트할 변수 초기화
		cnt = 0;
		// 테이블를 조회하며 블럭을 찾아 리스트에 저장한다
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] == 1) {
					findBlock(i, j, cnt, 0, table, blockList);
					cnt++;
				}
			}
		}

		int answer = 0;

		// 전체 빈공간에 블럭을 하나씩 대본다
		for (Block blank : blankList) {
			a: for (Block block : blockList) {
				// [조건] '게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 됩니다.'
				// => 사이즈가 같은지 체크
				if (blank.size() == block.size()) {
					// 4방향으로 돌려본다
					for (int i = 0; i < 4; i++) {
						// 블럭을 회전하면 음수 값이 발생하는데, 
						// 이것의 기준점을 0,0으로 맞추기 위해 제일 작은 값과 0,0의 차이를 구함
						int[] diff = { -block.get(0)[0], -block.get(0)[1] };
						// 일치 여부
						boolean flag = true;
						// 일치하는지 확인
						for (int idx = 0; idx < block.size(); idx++) {
							int[] currBlank = blank.get(idx);
							int[] currBlock = block.get(idx);
							// 일치하지않으면 다음을 확인하지 않고 다음 방향으로 돌리거나 다음 블럭을 대본다
							if (currBlock[0] + diff[0] != currBlank[0] || currBlock[1] + diff[1] != currBlank[1]) {
								flag = false;
								break;
							}
						}
						// 일치하면 answer값 증가, 블럭리스트에서 삭제
						if (flag) {
							answer += block.size();
							blockList.remove(block);
							break a;
						}
						// 블럭을 반시계방향으로 회전
						rotation(block);
					}
				}
			}
		}

		return answer;
	}

	private static void rotation(Block block) {
		// 반시계방향으로 회전
		for (int i = 0; i < block.size(); i++) {
			int[] curr = block.get(i);
			int temp = curr[0];
			curr[0] = -curr[1];
			curr[1] = temp;
		}
		// 회전 후 x값을 우선, y값을 다음 우선 기준으로 정렬
		Collections.sort(block.xy,
				(o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
	}

	/**
	 * 
	 * @param x		현재 x 값
	 * @param y 	현재 y좌표값
	 * @param cnt	몇 번째 블럭인지
	 * @param flag	빈공간을 찾는 경우 1, 블럭을 찾는 경우 0
	 * @param board	탐색하는 판
	 * @param list	빈공간 혹은 블럭을 저장하는 리스트
	 */
	private static void findBlock(int x, int y, int cnt, int flag, int[][] board, LinkedList<Block> list) {
		// 4방향
		int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// 처음 시작부분을 queue에 넣음
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		// 방문 처리
		board[x][y] = flag;
		// 블럭 혹은 빈공간 리스트에 블럭을 하나 추가하고, 블럭의 좌표리스트에 해당 1x1격자 위치를 추가
		list.add(new Block());
		list.get(cnt).add(new int[] { 0, 0 });
		// 인접한 공간에 빈공간 또는 블럭이 없을 때까지 조회
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!(0 <= nx && nx < board.length && 0 <= ny && ny < board.length) || board[nx][ny] == flag) {
					continue;
				}
				que.offer(new int[] { nx, ny });
				board[nx][ny] = flag;
				list.get(cnt).add(new int[] { nx - x, ny - y });
			}
		}
		// 블럭을 구성하는 좌표가 오름차순이어야하므로 정렬
		Collections.sort(list.get(cnt).xy,
				(o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
	}
}
