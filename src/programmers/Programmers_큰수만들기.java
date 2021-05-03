package programmers;

//ㅂㅂ
public class Programmers_큰수만들기 {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();

		char[] cNum = number.toCharArray();
		int idx = 0;

		while (k > 0) {
			int max = cNum[idx];
			int max_idx = idx;
			for (int j = idx + 1; j <= idx + k; j++) {
				if (max < cNum[j]) {
					max = cNum[j];
					max_idx = j;
				}
			}
			k -= (max_idx - idx);
			sb.append(max - '0');
			idx = max_idx + 1;
		}
		for (int i = idx; i < cNum.length; i++) {
			sb.append(cNum[i]);
		}

		return sb.toString();
	}
}
