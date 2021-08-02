package programmers.level2;

import java.util.Arrays;

// Programmers_행렬의곱셈_level2
public class Programmers_행렬의곱셈 {
	public static void main(String[] args) {
//		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };
//		int[][] arr2 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] arr2 = { { 1, 2 }, { 3, 4 } };
		int[][] answer = solution(arr1, arr2);
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 *     a11 a12
	 * A = a21 a22
	 * 	   b11 b12
	 * B = b21 b22
	 * 
	 *       a11*b11+a12*b21 a11*b12+a12*b22
	 * AxB = a21*b11+a22*b21 a21*b12+a22*b22
	 */
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		// MxA 행렬과 AxN행렬을 곱한 행렬의 크기는  MxN임
		int[][] answer = new int[arr1.length][arr2[0].length];
		// 앞 행렬의 행과
		for (int i = 0; i < arr1.length; i++) {
			// 뒷 행렬의 열끼리 계산
			for (int j = 0; j < arr2[0].length; j++) {
				// 행번호와 열번호가 같은 것끼리 곱함
				for (int k = 0; k < arr1[i].length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return answer;
	}
}
