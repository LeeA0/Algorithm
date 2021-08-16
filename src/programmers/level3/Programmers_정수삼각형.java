package programmers.level3;

// Programmers_정수삼각형_level3
public class Programmers_정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(solution(triangle));
	}
	
//	=> 위에서부터 큰 값만 가지고내려갈 경우 맨 밑에 엄청 큰 숫자가 있으면 역전될 가능성이 있어 위험하다
//	=> 따라서 맨 밑에서부터 큰 값만 가지고 올라온다
//	7							  11+7
//	3 8				 3+8 8+1	  11 9
//	8 1 0 =>8 1 0 => 8   1   0 => 8  1  0
//	
//	=> 답은 18
	
	public static int solution(int[][] triangle) {
		// 맨끝에서 2번째 줄부터 계산
		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				// 밑에 있는 원소 중 큰 숫자를 현재위치에 더함
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}
		// 맨 꼭대기값을 반환
		return triangle[0][0];
	}
}
