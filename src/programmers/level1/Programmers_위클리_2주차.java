package programmers.level1;

// Programmers_위클리_2주차_level1
public class Programmers_위클리_2주차 {
	public static void main(String[] args) {
		int[][] scores = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
				{ 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };
		System.out.println(solution(scores));
	}

	public static String solution(int[][] scores) {
		// 정답을 저장하는 StringBuilder
		StringBuilder answer = new StringBuilder();
		// 학생 한명한명의 접수를 구하기위해 열로 순회
		for (int j = 0; j < scores[0].length; j++) {
			// 최대값 최소값 초기화
			int max = 0;
			int min = 100;
			// 점수의 합
			int sum = 0;
			// 행으로 점수 조회
			for (int i = 0; i < scores.length; i++) {
				// 자기자신이 평가한 점수를 제외하고 min과 max를 판단
				if (i != j) {
					max = Math.max(max, scores[i][j]);
					min = Math.min(min, scores[i][j]);
				}
				// 점수를 더함
				sum += scores[i][j];
			}
			// 자기자신이 평가한 점수가 최댓값보다 크거나 작으면 자기가 평가한 점수를 제외하고 평균을 구함
			if (scores[j][j] > max || scores[j][j] < min) {
				sum -= scores[j][j];
				sum /= scores.length - 1;
			}
			// 아니면 자기 자신이 평가한 점수를 포함하고 평균을 구함
			else {
				sum /= scores.length;
			}
			// 10으로 나눠서 점수대의 학점을 줌
			switch (sum / 10) {
			case 9:
				answer.append("A");
				break;
			case 8:
				answer.append("B");
				break;
			case 7:
				answer.append("C");
				break;
			case 6:
			case 5:
				answer.append("D");
				break;
			default:
				answer.append("F");
				break;
			}

		}
		return answer.toString();
	}
}
