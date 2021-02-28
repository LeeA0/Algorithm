package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_Fly me to the Alpha Centauri_1011_실버1
public class BOJ_1011_FlymetotheAlphaCentauri {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 거리를 구함
			// ex) dist = 7
			int dist = y - x;
			
			// 해당 값의 제곱근보다 같거나 큰 제곱근을 구함
			// ex) i = 3
			int i = (int) Math.ceil(Math.sqrt(dist));
			
			// 구한 제곱근의 최소 이동 수를 구한다
			// ex) 9 - 4 = 5 => 거리가 9일 때 최소 이동 수 5
			int step = (int) (Math.pow(i, 2) - Math.pow(i - 1, 2));
			
			// 구한 제곱근의 숫자와 같은 최소 이동 수를 갖는 영역의 크기를 계산
			// ex) 5/2 = 2 
			int size = step / 2;
			
			// 구한 제곱근의 숫자와 같은 영역에 있으면
			// ex) => 9-2=7 => 7~9의 최소 이동 수 5
			if (dist >= Math.pow(i, 2) - size) {
				// 최소이동 수 그대로 출력
				sb.append(step).append("\n");
			}
			// 작으면
			else {
				// 최소이동 수 - 1을 출력
				sb.append(step - 1).append("\n");
			}
		}
		System.out.print(sb);
	}
}
