package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_주식가격 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] prices = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(solution(prices)));
	}

	// 주식 클래스
	static class Stock {
		// 스택에 넣는 시점(인덱스)
		int idx;
		// 주식의 가격
		int price;

		public Stock(int idx, int price) {
			this.idx = idx;
			this.price = price;
		}
	}

	static int[] solution(int[] prices) {
		// 정답을 저장하는 배열
		int[] answer = new int[prices.length];

		// 주식을 저장할 stack 선언
		Stack<Stock> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			// 스택에 저장된 주식을 훑기 위해 iterator선언
			Iterator<Stock> iter = stack.iterator();
			// 다음 주식이 있으면
			while (iter.hasNext()) {
				// 스택에 저장되어있는 주식의 시간을 +1해준다
				answer[iter.next().idx]++;
			}
			while (true) {
				// 스택이 비어있지않고, 현재 제일 상위에있는 주식의 가격보다 현재가격이 작으면
				if (!stack.isEmpty() && stack.peek().price > prices[i]) {
					// 가격이 내려간 것이므로 스택에서 제거
					stack.pop();
				}
				// 상승세면 스택에서 빼 줄 필요없으므로 break
				else {
					break;
				}
			}
			// 다음 주식을 넣는다
			stack.push(new Stock(i, prices[i]));
		}

		return answer;
	}
}
