package programmers.level2;

import java.util.Arrays;

// Programmers_다음큰숫자_level2
public class Programmers_다음큰숫자 {

	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
	}

//	public static int solution(int n) {
//		int bitnumN = Integer.bitCount(n);
//		int answer = n + 1;
//		while (true) {
//			if (bitnumN == Integer.bitCount(answer)) {
//				break;
//			}
//			answer++;
//		}
//		return answer;
//	}

	public static int solution(int n) {
		char[] binaryN = Integer.toBinaryString(n).toCharArray();
		char[] binaryNext = new char[binaryN.length + 1];
		Arrays.fill(binaryNext, '0');
		boolean flag = true;
		int oneCount = 0;

		for (int i = binaryN.length - 1; i >= 0; i--) {
			if (flag) {
				if (i == 0 || (binaryN[i] == '1' && binaryN[i - 1] == '0')) {
					binaryNext[i] = '1';
					i--;
					flag = false;
				} else if (binaryN[i] == '1') {
					oneCount++;
				}
			} else {
				binaryNext[i + 1] = binaryN[i];
			}
		}
		for (int i = 1; i <= oneCount; i++) {
			binaryNext[binaryNext.length - i] = '1';
		}
		return Integer.parseInt(new String(binaryNext), 2);
	}
}
