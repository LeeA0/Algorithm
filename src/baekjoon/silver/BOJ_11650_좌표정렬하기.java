package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준_11650_좌표정렬하기_실버5
public class BOJ_11650_좌표정렬하기 {
	// 좌표 객체
	public static class Point implements Comparable<Point>{
		int x; // x좌표
		int y; // y좌표
		
		// 생성자
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		// priority queue에 넣었을 때의 기준을 만들어준다
		@Override
		public int compareTo(Point o) {
			// 좌표들의 x값이 다르면
			if(this.x!=o.x) {
				// x좌표가 증가하는 순으로 정렬
				return Integer.compare(this.x, o.x);
			}
			// 아니면 y좌표가 증가하는 순으로 정렬
			return Integer.compare(this.y, o.y);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 들어오는 Point객체를 우선순위에 맞게 자동으로 정렬해주기 위해 Priority Queue를 선언
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		// 들어오는 좌표의 수
		int N = Integer.parseInt(br.readLine().trim());
		// 좌표 입력
		for (int i = 0; i < N; i++) {
			// 공백을 기준으로 나누어져있는 데이터를 저장하기위해 StringTokenizer이용
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// pq에 좌표값을 저장
			pq.offer(new Point(x,y));
		}// 입력완료
		
		// 여러 번의 출력을 최적화하기위해 Stringbuilder를 사용
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			// 정렬되어있는 순서대로 받아온다
			Point p = pq.poll();
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		
		System.out.print(sb);
	}
}
