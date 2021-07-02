package programmers.level2;

// Programmers_단체사진찍기_level2
public class Programmers_단체사진찍기 {

	public static void main(String[] args) {
		int n = 2;
		String[] data = { "M~C<2", "C~M>1" };
		System.out.println(solution(n, data));
	}

	// 경우의 수
	static int answer;
	// 프렌츠 이름
	static char[] friends = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };

	public static int solution(int n, String[] data) {
		// 초기화
		answer = 0;
		// 모든 경우의 수를 구해본다
		nPr(0, new char[8], new boolean[8], data);
		return answer;
	}

	public static void nPr(int cnt, char[] save, boolean[] isSelected, String[] data) {
		// 모든 프렌즈의 위치를 선정했으면
		if (cnt == 8) {
			// 조건에 맞는지 체크한 후 맞으면 경우의 수 +1
			if (check(save, data)) {
				answer++;
			}
			return;
		}
		// 0~7번까지 매 자리마다 모든 경우의 수를 구한다
		for (int i = 0; i < 8; i++) {
			// 이미 자리를 고른 프렌즈는 건너 뜀
			if (isSelected[i]) {
				continue;
			}
			// 자리를 골랐다고 표시
			isSelected[i] = true;
			// 자리를 정한 프렌즈를 저장
			save[cnt] = friends[i];
			// 다음 자리 결정
			nPr(cnt + 1, save, isSelected, data);
			// 다음 자리를 위해 자리를 골랐다는 표시 삭제
			isSelected[i] = false;
		}
	}

	// 조건에 맞는 지 검사
	public static boolean check(char[] save, String[] data) {
		// 조건의 크기만큼 반복
		for (int i = 0; i < data.length; i++) {
			// 조건을 제시한 프렌즈
			int request = -1;
			// 상대방 프렌즈
			int partner = -1;
			// 조건을 제시한 프렌즈와 상대방 프렌즈의 위치를 찾음
			for (int j = 0; j < save.length; j++) {
				if (save[j] == data[i].charAt(0)) {
					request = j;
				}
				if (save[j] == data[i].charAt(2)) {
					partner = j;
				}
			}
			// 4번째 글자의 연산자에 따라 범위 체크가 달라짐
			switch (data[i].charAt(3)) {
			// 사이에 5번째 글자만큼 프렌즈가 있음
			case '=':
				// 다르면 false
				if (Math.abs(request - partner) - 1 != data[i].charAt(4)-'0') {
					return false;
				}
				break;

			// 사이에 5번째 글자미만의 프렌즈가 있음	
			case '<':
				// 이상이면 false
				if(Math.abs(request-partner)-1 >= data[i].charAt(4)-'0') {
					return false;
				}
				break;
			// 사이에 5번째 글자초과의 프렌즈가 있음
			case '>':
				// 이하이면 false
				if(Math.abs(request-partner)-1 <= data[i].charAt(4)-'0') {
					return false;
				}
				break;
			}
		}
		// 조건에 전부 맞으면 true
		return true;
	}
}
