package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//백준_ACM호텔_10250_브론즈3
public class BOJ_10250_ACM호텔 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			// 건물높이
			int H = Integer.parseInt(st.nextToken());
			// 건물너비
			int W = Integer.parseInt(st.nextToken());
			// N번째 손님
			int N = Integer.parseInt(st.nextToken());
			
			// 나머지 연산자를 이용해 N번째 손님이 묵을 곳의 층 수를 구한다.
			int h = N%H;
			// 나눈 후 올림을 통해 N번째 손님이 묵을 곳의 호수를 구한다.
			int w = (int)Math.ceil((double)N/(double)H);
			// h가 0이면 꼭대기 층이다.
			bw.write(Integer.toString(h==0?H:h));
			// 호수는 두자리수로 출력해줘야한다.
			bw.write(String.format("%02d", w));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
