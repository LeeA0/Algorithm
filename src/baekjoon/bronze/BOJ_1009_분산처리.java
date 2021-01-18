package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_분산처리_1009_브론즈3
public class BOJ_1009_분산처리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		// 각 숫자의 제곱 규칙을 적어준다
		// 0으로 끝나는 경우 10번 컴퓨터를 사용한다
		int[][] save = {{10}, {1}, { 2, 4, 8, 6 }, { 3, 9, 7, 1 }, { 4, 6 }, { 5 }, { 6 }, { 7, 9, 3, 1 }, { 8, 4, 2, 6 },{ 9, 1 } };
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			// 일의 자리 수만 같으면 된다
			int base = Integer.parseInt(st.nextToken())%10;
			int exp = Integer.parseInt(st.nextToken())-1;
			
			sb.append(save[base][exp%save[base].length]).append("\n");
		}
		System.out.print(sb);
	}
}
