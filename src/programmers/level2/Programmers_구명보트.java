package programmers.level2;

import java.util.Arrays;

public class Programmers_구명보트 {
	public static void main(String[] args) {
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(solution(people, limit));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		// 남은 사람 중 제일 몸무게가 작은 사람과 큰 사람을 같이 보내야 limit보다 작을 확률이 높으므로 정렬
		Arrays.sort(people);
		// 왼쪽 인덱스
		int left = 0;
		// 오른쪽 인덱스
		int right = people.length - 1;
		// 왼쪽 인덱스가 오른쪽인덱스보다 작거나 같을 때까지 반복
		while (left <= right) {
			// 만약 가장 몸무게가 작은 사람과 큰 사람의 몸무게 합이 limit보다 작거나 같으면 함께 보트에 태워 보냄
			if(people[left]+people[right]<=limit) {
				answer++;
				left++;
				right--;
			}
			// 그렇지 않으면 몸무게가 큰 사람만 태워 보냄
			else {
				answer++;
				right--;
			}
		}
		return answer;
	}
}
