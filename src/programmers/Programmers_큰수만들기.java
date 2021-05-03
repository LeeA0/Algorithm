package programmers;

//ㅂㅂ
public class Programmers_큰수만들기 {

	public static void main(String[] args) {
		String number = "192222";
		int k = 3;
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		// 문자열을 추가하는 Stringbuilder
		StringBuilder sb = new StringBuilder();

		// 문자열을 문자배열로 변환
		char[] cNum = number.toCharArray();
		// 기준이 될 idx 선언
		int idx = 0;

		// 빼는 문자의 개수가 0보다 크고, 인덱스가 범위를 벗어나지 않은 동안 반복
		while (k > 0 && idx < cNum.length) {
			// 가장 큰 수를 첫번째수로 초기화
			int max = cNum[idx];
			// 가장 큰수의 인덱스를 첫번째 수의 인덱스로 초기화
			int max_idx = idx;
			// 만약 남은 숫자의 개수가 K보다 작으면 나머지는 전부 빼는 문자이므로 idx를 끝까지 이동시키고 멈춘다
			if (k > cNum.length - idx - 1) {
				idx += k;
				break;
			}
			// 전체 문자의 수가 10, k가 4라고 했을 때, 처음부터 전부 뺀다고 가정하면 0~4번까지 생략이 가능하다
			// 그래서 그 범위 중 가장 큰 수자를 고르고, 제거한 문자 수만큼 k에서 뺴준다
			
			// 범위에서 가장 큰 숫자를 찾는다
			for (int j = idx + 1; j < cNum.length && j <= idx + k; j++) {
				// 현재 문자가 가장 큰 수면 저장
				if (max < cNum[j]) {
					max = cNum[j];
					max_idx = j;
				}
			}
			// k를 제거한 문자 수 만큼 뺌
			k -= (max_idx - idx);
			// 가장 큰 숫자를 append
			sb.append(max - '0');
			// 가장 큰 숫자 다음으로 인덱스를 이동
			idx = max_idx + 1;
		}
		// 전부 반복하고 남은 숫자를 추가한다
		for (int i = idx; i < cNum.length; i++) {
			sb.append(cNum[i]);
		}

		return sb.toString();
	}
}
