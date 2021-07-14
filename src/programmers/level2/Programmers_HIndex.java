package programmers.level2;

import java.util.Arrays;

public class Programmers_HIndex {

	public static void main(String[] args) {
		int[] citations = { 20, 19, 18, 17 };
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		// 배열을 오름차순으로 정렬
		Arrays.sort(citations);
		// 이분탐색을 위해 left, right변수 선언
		int left = 0;
		int right = citations.length - 1;
		// hIndex를 저장할 변수
		int hIndex = 0;
		// 이분탐색
		while (left <= right) {
			// 가운데 값을 구한다
			int mid = (left + right) / 2;
			// 구한 가운데 값을 기준으로 전체 논문 수에서 뺴서 해당 기준 값보다 많이 인용한 논문수를 구함
			// ex) 5개의 논문 중 2번째 논문의 값이 3일 경우 뒤에 있는 나머지 논문의 인용수는 오름차순 정렬순이므로 3보다 많이 인용됨
			// => 4개의 논문이 3회이상 인용됨
			int num = citations.length - mid;
			// 인용된 논문 수가 해당 배열값보다 크면 논문수를 줄이기 위해 left를 증가 후 다음단계 진행
			if (num > citations[mid]) {
				left = mid + 1;
			} 
			// 인용된 논문 수가 해당 배열값보다 작으면 
			// hIndex일 가능성이 있으므로 hIndex와 인용된 논문 수를 비교해서 가장 큰 값을 저장하고
			// 인용된 논문수를 늘이기 위해 right를 감소 후 다음단계 진행
			else {
				hIndex = Math.max(hIndex, num);
				right = mid - 1;
			}
		}
		return hIndex;
	}
}
