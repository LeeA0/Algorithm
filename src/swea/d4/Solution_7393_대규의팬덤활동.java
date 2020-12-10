package swea.d4;

import java.util.Scanner;

//SW_대규의팬덤활동_7393_D4
//->백준 1562 계단수_골드
public class Solution_7393_대규의팬덤활동 {
	static int N;
	static int[][][] dp;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();

		// 1~N줄, 9개의 끝나는 자리수, 숫자가 사용됬는지 확인 0~1023
		// 0000000000 : 한개도 선택되지 않음
		// 0000000001 (1) : 0만 사용
		// 0000000010 (2) : 1만 사용
		// 0000000011 (3) : 0,1사용
		// ...
		// 1111111111 (1023) : 0~9사용
		// [i][j][bit] 
		// += [i-1][j-1][k] + [i-1][j+1][k]
		dp = new int[N + 1][9][1<<10];
		for (int i = 1; i < 10; i++) {
			
		}
		for (int i = 1; i < N+1; i++) {
			
		}
	}

}
