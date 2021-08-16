package programmers.level3;

import java.util.Arrays;

// Programers_야근지수_level3
public class Programmers_야근지수 {
	public static void main(String[] args) {
		int n = 3;
		int[] works = { 4, 3, 3, 3 };
		System.out.println(solution(n, works));
	}

	public static long solution(int n, int[] works) {
		// 오름차순으로 정렬
		Arrays.sort(works);
		// 가장 큰 숫자부터 조금씩 깎는다
		for (int i = works.length - 1; i >= 0; i--) {
			// i가 맨 끝 열이 아니고, 이전 값과 같으면 continue
			if (i != 0 && works[i] == works[i - 1]) {
				continue;
			}
			// 맨끝까지 값이 같으면 step을 해당값으로, 아니면 이전 값과의 차이로
			int step = i == 0 ? works[i] : works[i] - works[i - 1];
			// 뒤로 몇 개가 있는지 체크
			int num = works.length - i;
			// 3,4,5,6,6,6일때 i가 3일 때 뒤로 같은 숫자가 3개가 있고, i번째를 깎을 때 뒤의 숫자도 깎아야 함
			// 깎을 숫자가 넉넉하면 차례로 깎아줌
			if (step * num <= n) {
				n -= step * num;
				for (int j = i; j < works.length; j++) {
					works[j] -= step;
				}
			} 
			// 깎을 숫자가 모자라면
			else {
				// 균등하게 분배한 값
				int diff = n / num;
				// 분배하고 남은 값
				int remain = n % num;
				// 전체 값에 균등하게 분배
				for (int j = i; j < works.length; j++) {
					works[j] -= diff;
				}
				// 남은 값을 1씩 분배
				for (int j = i; j < i + remain; j++) {
					works[j]--;
				}
				break;
			}
		}
		// 남은 배열값을 제곱해서 답을 구함
		long answer = 0;
		for (int i = 0; i < works.length; i++) {
			answer += (long) works[i] * (long) works[i];
		}
		return answer;
	}
}
