package elice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Elice_엘리스와별헤는밤 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int distance = Integer.parseInt(br.readLine());
		// 정답(하늘) StringBuilder
		StringBuilder skySb = new StringBuilder();
		// 공백만드는 StringBuilder
		StringBuilder spaceSb = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			spaceSb.append(" ");
		}
		// 공백을 사용하기 쉽게 String으로 자료 변경
		String space = spaceSb.toString();
		// 첫째줄
		skySb.append("*");
		for (int i = 0; i < 2; i++) {
			skySb.append(space).append("*");
		}
		skySb.append("\n");

		// 둘째줄
		// 왼쪽 공백의 크기 : ((첫쨰줄공백)*2 + (별세개) - ((가운데 공백길이) + (별두개)) ) / 2
		// => 짝수일 때 : (dist*2+3-dist+1-2)/2 = (dist+2)/2
		if (distance % 2 == 0) {
			skySb.append(space.substring(0, (distance + 2) / 2));
		}
		// => 홀수일 떄 : (dist*2+3-dist-2)/2 = (dist+1)/2
		else {
			skySb.append(space.substring(0, (distance + 1) / 2));
		}
		skySb.append("*");
		// 짝수일 때 별의 거리 - 1
		if (distance % 2 == 0) {
			skySb.append(space.substring(0, distance - 1));
		} 
		// 홀수일 때 별의 거리 그대로
		else {
			skySb.append(space);
		}
		skySb.append("*");

		System.out.println(skySb.toString());
	}
	
	// 엘리스 실행법을 몰라서 시초난 줄알고 버렸던 코드
	// 알고보니 잘된다 ㅎ
//	public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int distance = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		sb.append("*");
//		for (int i = 0; i < 2; i++) {
//			space(distance, sb);
//			sb.append("*");
//		}
//		sb.append("\n");
//
//		if (distance % 2 == 0) {
//			space((distance + 2) / 2, sb);
//		} else {
//			space((distance + 1) / 2, sb);
//		}
//		sb.append("*");
//		if (distance % 2 == 0) {
//			space(distance - 1, sb);
//		} else {
//			space(distance, sb);
//		}
//		sb.append("*");
//
//		System.out.println(sb.toString());
//	}
//
//	public static void space(int distance, StringBuilder sb) {
//		for (int i = 0; i < distance; i++) {
//			sb.append(" ");
//		}
//	}
}
