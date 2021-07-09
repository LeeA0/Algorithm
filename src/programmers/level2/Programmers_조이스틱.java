package programmers.level2;

import java.util.Arrays;

// Programmers_조이스틱_level2
public class Programmers_조이스틱 {
	public static void main(String[] args) {
		String name = "ABABAAAAAAABA";
		System.out.println(solution(name));
	}

	// 최소 횟수를 저장하는 변수
	static int answer;

	public static int solution(String name) {
		// 최소값을 찾는 것이므로 최대값으로 초기화
        answer = Integer.MAX_VALUE;
        // 변환된 문자열을 저장하는 save 배열
		char[] save = new char[name.length()];
		// A로 전부 초기화
		Arrays.fill(save, 'A');
		// 이동
		move(0, 0, name, save);
		return answer;
	}

	private static void move(int cursor, int move, String name, char[] save) {
		// 문자 변환이 완료되면 최소값을 찾아 저장
		if (name.equals(new String(save))) {
			// 다음으로 넘어올 때 불필요한 1이 증가되므로 1을 빼줌
			// 처음부터 일치하는 AAAA의 경우 옮길 필요가 없으므로 0반환
			answer = Math.min(answer, move - 1 < 0 ? 0 : move - 1);
			return;
		}
		// 현재 이동횟수가 현재 최소이동횟수보다 크거나 같으면 더 갈 필요없다.
		if (answer <= move) {
			return;
		}
		// up 혹은 down했을 때 가장 적은 횟수를 증가시켜줌
		move += Math.min(name.charAt(cursor) - 'A', 'A' + 26 - name.charAt(cursor));
		// 나중에 되돌리기위해 현재 cursor의 알파벳을 저장
		char temp = save[cursor];
		// 변환 후 변환된 알파벳을 저장
		save[cursor] = name.charAt(cursor);
		// 오른쪽으로 이동
		move((cursor + 1) % name.length(), move + 1, name, save);
		// 왼쪽으로 이동
		move(cursor - 1 < 0 ? name.length() - 1 : cursor - 1, move + 1, name, save);
		// 변환 된 알파벳을 원상복귀
		save[cursor] = temp;
	}
}
