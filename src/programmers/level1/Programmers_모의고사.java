package programmers.level1;

import java.util.Arrays;

// Programmers_모의고사_level1
public class Programmers_모의고사 {
	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };
		System.out.println(Arrays.toString(solution(answers)));
	}

	public static int[] solution(int[] answers) {
		// 1번 수포자가 찍는 방식
		int[] p1 = { 1, 2, 3, 4, 5 };
		// 2번 수포자가 찍는 방식
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		// 3번 수포자가 찍는 방식
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		// 1,2,3번의 정답 문제 개수
		int[] cnt = new int[3];

		// answer를 돌려 1, 2, 3번의 정답 수를 센다
		for (int i = 0; i < answers.length; i++) {
			// i%p.length : 각각 찍는 방식의 패턴 길이가 다르므로 영역을 벗어나지않게 %로 계산
			if (answers[i] == p1[i % p1.length]) {
				cnt[0]++;
			}
			if (answers[i] == p2[i % p2.length]) {
				cnt[1]++;
			}
			if (answers[i] == p3[i % p3.length]) {
				cnt[2]++;
			}
		}
		
		// 1,2,3번 수포자 중 제일 많이 맞은 학생의 정답 문제 수를 구함
		int max = Math.max(cnt[0], cnt[1]);
		max = Math.max(max, cnt[2]);

		// 많이 맞춘 학생의 수를 구한다.
		int len = 0;
		for (int i = 0; i < 3; i++) {
			if (max == cnt[i]) {
				len++;
			}
		}
		
		// 많이 맞춘 학생을 담을 배열
		int[] answer = new int[len];
		
		// 많이 맞춘 학생을 담는다
		int j = 0;
		for (int i = 0; i < 3; i++) {
			if (max == cnt[i]) {
				answer[j] = i + 1;
				j++;
			}
		}

		return answer;
	}
}
