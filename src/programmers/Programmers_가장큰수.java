package programmers;

import java.util.Collections;
import java.util.LinkedList;

// Programmers_가장큰수_level2
public class Programmers_가장큰수 {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9,0 };
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		// 정답을 저장할 StringBuilder
		StringBuilder sb = new StringBuilder();
		// 정렬하기위해 list로 변형
		LinkedList<Integer> numberList = new LinkedList<>();
		for (int n : numbers) {
			numberList.add(n);
		}
		
		// (문자열) o1+o2와 o2+o1를 비교해서 합이 큰 순서대로 나열한다
		Collections.sort(numberList, (o1, o2) -> Integer.compare(sum(o2, o1), sum(o1, o2)));

		// 순서대로 문자열로 만든다
		for (int n : numberList) {
			sb.append(n);
		}

		// 맨 처음 부터 000이면 0으로 치환
		return sb.toString().replaceAll("^[0]{2,}", "0");
	}

	// int형 숫자 두 개를 문자열로 바꿔서 합한 후 int로 반환
	public static int sum(int a, int b) {
		return Integer.parseInt(Integer.toString(a) + Integer.toString(b));
	}
}

// 나의 뻘짓 역사..
//static class Number implements Comparable<Number> {
//	char[] num;
//
//	public Number(char[] num) {
//		super();
//		this.num = num;
//	}
//
//	@Override
//	public int compareTo(Number o) {
//		int idx = 0;
//		int shortLen = Math.min(this.num.length, o.num.length);
//		while (idx < shortLen) {
//			if (this.num[idx] == o.num[idx]) {
//				idx++;
//			} else {
//				return Integer.compare(o.num[idx], this.num[idx]);
//			}
//		}
//		if (this.num.length > o.num.length) {
//			if (this.num[idx] == o.num[0]) {
//				return -1;
//			} else {
//				return Integer.compare(o.num[0], this.num[idx]);
//			}
//		} else if (this.num.length < o.num.length) {
//			if (this.num[0] == o.num[idx]) {
//				return 1;
//			} else {
//				return Integer.compare(o.num[idx], this.num[0]);
//			}
//		} else {
//			return 0;
//		}
//	}
//}
//
//public static String solution(int[] numbers) {
//	StringBuilder sb = new StringBuilder();
//
//	PriorityQueue<Number> pq = new PriorityQueue<>();
//	for (int number : numbers) {
//		pq.offer(new Number(Integer.toString(number).toCharArray()));
//	}
//
//	int size = pq.size();
//	for (int i = 0; i < size; i++) {
//		Number curr = pq.poll();
//		for (char c : curr.num) {
//			sb.append(c);
//		}
//	}
//
//	return sb.toString();
//}
