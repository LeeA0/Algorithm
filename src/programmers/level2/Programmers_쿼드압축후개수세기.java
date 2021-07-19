package programmers.level2;

import java.util.Arrays;

// Programmers_쿼드압축후개수세기_level2
public class Programmers_쿼드압축후개수세기 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
		System.out.println(Arrays.toString(solution(arr)));
	}

	// quad에서 0과 1의 개수를 세서 저장하기위해 전역변수로 선언
	static int[] answer;

	public static int[] solution(int[][] arr) {
		// 0과 1의 개수 2개만을 저장하므로 길이는 2
		answer = new int[2];
		// 처음에는 큰 한덩어리로 시작
		quad(0, 0, arr.length, arr[0].length, arr);
		// 재귀가 끝난 후 정답 반환
		return answer;
	}

	/**
	 * 쿼드압축을 위한 재귀함수
	 * @param sx, sy : 사각형의 왼쪽 위 모서리의 좌표 값
	 * @param ex, ey : 사각형의 오른쪽 아래 모서리의 좌표 값
	 * @param arr : 주어진 배열
	 */
	public static void quad(int sx, int sy, int ex, int ey, int[][] arr) {
		// 사각형 안의 숫자가 같은지 판별하기 위해 맨 왼쪽 위 모서리의 값을 저장
		int flag = arr[sx][sy];
		// 사각형을 탐색하며 값이 같은지 살펴봄
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				// 만약 값이 다르면
				if (flag != arr[i][j]) {
					// 중간 좌표를 구한 후
					int mx = sx + (ex - sx) / 2;
					int my = sy + (ey - sy) / 2;
					// 1 | 2
					// -----
					// 3 | 4 라고했을 때,
					
					// 1사분면
					quad(sx, sy, mx, my, arr);
					// 2사분면
					quad(sx, my, mx, ey, arr);
					// 3사분면
					quad(mx, sy, ex, my, arr);
					// 4사분면
					quad(mx, my, ex, ey, arr);
					// 으로 나눠서 똑같이 반복 후 리턴
					return;
				}
			}
		}
		// 전부 같은 숫자면 사각형을 차지하는 숫자의 개수를 1 증가
		answer[flag]++;
	}
}
