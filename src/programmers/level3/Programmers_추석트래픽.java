package programmers.level3;

public class Programmers_추석트래픽 {
	public static void main(String[] args) {
		String[] lines = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		System.out.println(solution(lines));
	}

	public static int solution(String[] lines) {
		// lines의 시간을 ms단위의 정수로 만들어서 시작 시간과 종료 시간을 저장
		int[][] times = new int[lines.length][2];
		for (int i = 0; i < lines.length; i++) {
			String[] traffic = lines[i].split(" ");
			// String 자료형이었던 종료 시간을 ms단위의 int형으로 변경
			int endTime = timeStringToInt(traffic[1]);
			// 처리시간 뒤에 붙은 s를 떼고 float으로 만든 후 ms단위의 int형으로 변경
			int duringTime = (int) (Float.parseFloat(traffic[2].substring(0, traffic[2].length() - 1)) * 1000);
			// 시작시간 = 종료시간 - 처리시간
			int startTime = endTime - (duringTime - 1);
			// 배열에 저장
			times[i] = new int[] { startTime, endTime };
		}

		int answer = 0;
		int idx = times.length - 1;

		// 주어지는 입력 값은 종료시간기준으로 정렬되어 있으므로 greedy한 방식을 사용하기위해 뒤에서부터 탐색
		for (int t = times[times.length - 1][1]; t >= times[0][0]; t--) {
			// t-999~t의 구간에서 처리된 트래픽의 개수
			int num = 0;
			// 0~idx의 트래픽 중에서 탐색
			for (int i = idx; i >= 0; i--) {
				// 종료시간이 t-999보다 작으면 범위에서 벗어나므로 그 뒤를 더 볼 필요가 없음
				if (times[i][1] < t - 999) {
					break;
				} 
				// 시작시간이 t보다 크면 범위에서 벗어난 것
				else if (times[i][0] > t) {
					// 비교의 시작부분이 범위에서 벗어나면 해당 트래픽은 그 이후에 더 볼 필요가 없으므로 idx를 이동
					if (i == idx) {
						idx--;
					}
				}
				// 나머지는 t-999~t에 처리 중인 트래픽이므로 개수 카운트
				else {
					num++;
				}
			}
			// num과 answer를 비교해 큰 값을 answer에 저장
			answer = Math.max(answer, num);
		}

		return answer;
	}

	// String형인 시간을 쪼개서 int형으로 변경
	public static int timeStringToInt(String time) {
		String[] times = time.split(":");
		int h = Integer.parseInt(times[0]);
		int m = Integer.parseInt(times[1]);
		float s = Float.parseFloat(times[2]);

		return (int) (((h * 60 + m) * 60 + s) * 1000);
	}
}
