package programmers.level1;

// Programmers_체육복_level1
public class Programmers_체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = {1, 3, 5};
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		// 현재 체육복을 입을 수 있는 사람의 수 = 전체 학생의 수 - 체육복을 잃어버린 학생의 수
		int answer = n - lost.length;
		
		// 여분의 체육복을 가지고 있던 학생 중 체육복을 잃어버린 학생을 체크한다
		// 이 학생은 다른 학생에게 체육복을 빌려줄 수 없다
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if(reserve[i]==lost[j]) {
					reserve[i]=-1;
					lost[j]=-1;
					answer++;
					break;
				}
			}
		}

		// 여분의 체육복을 가지고 있던 학생의 양 옆에 체육복을 잃어버린 학생이 있는 지 체크한 후 한명에게 빌려준다
		for (int i = 0; i < reserve.length; i++) {
			int curr = reserve[i];
			for (int j = 0; j < lost.length; j++) {
				if (curr - 1 == lost[j] || curr + 1 == lost[j]) {
					lost[j] = -1;
					answer++;
					break;
				}
			}
		}

		return answer;
	}
}
