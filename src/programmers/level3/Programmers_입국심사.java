package programmers.level3;

import java.util.Arrays;

// Programmers_입국심사_level3
public class Programmers_입국심사 {
	public static void main(String[] args) {
		int n = 1000000000;
		int[] times = { 1000000000, 1000000000 };
		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {
		// 최댓값과 최솟값을 찾기위해 정렬
		Arrays.sort(times);
		// 왼쪽 인덱스와 오른쪽 인덱스를 초기화
		long left = times[0], right = times[times.length - 1];
		// 만약 오른쪽 값으로 구한 인원 수가 목표인원수보다 작으면 
		// left를 기존의 right으로, right은 2배로 증가
		while (getPeople(right, times) < n) {
			left = right;
			right *= 2;
		}
		long answer = 0;
		// 이분 탐색
		while (left <= right) {
			long mid = (left + right) / 2;
			long midPeople = getPeople(mid, times);
			// 가운데 지점의 인원 수가 목표 인원수보다 작으면 기준점을 위로 올리기위해 left를 이동
			if (midPeople < n) {
				left = mid + 1;
			} 
			// 아니면 정답으로 저장하고, 기준점을 아래로 내리기위해 right를 이동
			else {
				answer = mid;
				right = mid - 1;
			}
		}
		return answer;
	}

	private static long getPeople(long totalTime, int[] times) {
		// 현재 시간에서 최대로 받을 수 있는 인원을 구함
		// long인 이유! totalTime이 long인데 times가 1이면 int범위를 넘을 수 있음
		long people = 0;
		for (int i = 0; i < times.length; i++) {
			people += totalTime / times[i];
		}
		return people;
	}
}
