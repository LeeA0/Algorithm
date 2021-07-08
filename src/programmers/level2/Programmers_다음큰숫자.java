package programmers.level2;

import java.util.Arrays;

// Programmers_다음큰숫자_level2
public class Programmers_다음큰숫자 {

	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
	}

	/**
	 * ex) 78 = 1001110(2)
	 * 1의 개수를 유지해야한다면 왼쪽으로 한 칸 옮길 수 있는 1을 찾은 후 옮기고
	 * 그 뒤에 있던 1은 맨 오른쪽으로 밀어버린다
	 * 그 이후에 있는 숫자들은 그대로하면 다음 큰 숫자가 된다
	 */
	public static int solution(int n) {
		// n을 2진수로 바꿔서 char배열로 생성
		char[] binaryN = Integer.toBinaryString(n).toCharArray();
		// ex) 10000인 경우를 대비해서 binaryN보다 1칸 큰 배열 생성
		char[] binaryNext = new char[binaryN.length + 1];
		// '0'으로 채운 뒤 '1'인 부분에 '1'만 넣어줄 계획
		Arrays.fill(binaryNext, '0');
		// 왼쪽으로 넘길 수 있는 위치에 있는 '1'을 찾았는지 여부 
		boolean flag = true;
		// 플래그 뒤에 있는 1의 개수
		int oneCount = 0;

		// 뒤에서부터 조회
		for (int i = binaryN.length - 1; i >= 0; i--) {
			// 한 단계 올릴 숫자를 찾지 못 했다면
			if (flag) {
				// 맨 끝의 숫자거나 01이 붙어있으면
				// 11이나 10은 다음 자리에 1을 올리지 못하므로 의미가 없다
				if (i == 0 || (binaryN[i] == '1' && binaryN[i - 1] == '0')) {
					// 1을 왼쪽으로 한칸 옮긴 위치에 넣음
					// binaryNext는 binaryN보다 한 칸 많으므로 그걸 염두해서 i에 넣음
					binaryNext[i] = '1';
					// 다음 칸으로 이동
					i--;
					// 플래그 사용했다는 표시
					flag = false;
				}
				// 플래그 전인데 1이 나오면 개수를 세준다
				else if (binaryN[i] == '1') {
					oneCount++;
				}
			}
			// 플래그를 처리한 뒤 나머지 숫자는 그대로 복사
			else {
				binaryNext[i + 1] = binaryN[i];
			}
		}
		// 플래그 뒤에 있던 1을 오른쪽정렬해서 추가해주기위해 1의 개수 만큼 오른쪽에 1을 추가해줌
		for (int i = 1; i <= oneCount; i++) {
			binaryNext[binaryNext.length - i] = '1';
		}
		// 만든 이진수를 int로 변환
		return Integer.parseInt(new String(binaryNext), 2);
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
}
