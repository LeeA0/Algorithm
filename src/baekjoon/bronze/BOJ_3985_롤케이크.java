package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_3985_롤케이크_브론즈1
public class BOJ_3985_롤케이크 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int[] rollCake = new int[L + 1];

		// 가장 많은 조각을 받을 것으로 기대하는 방청객의 번호
		int maxExpectPiecePerson = 0;
		// 가장 많은 조각을 받을 것으로 기대되는 방청객의 조각 수
		int maxExpectPiece = 0;
		// 가장 많은 조각을 받은 방청객의 번호
		int maxReceivePiecePerson = 0;
		// 가장 많은 조각을 받은 방청객의 조각 수
		int maxReceivePiece = 0;
		// N명의 방청객
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			// 받아가는 조각의 시작 숫자
			int startNum = Integer.parseInt(st.nextToken());
			// 받아가는 조각의 끝 숫자
			int endNum = Integer.parseInt(st.nextToken());

			// 받을 수 있을 것으로 예상되는 조각의 수를 구함
			int expectPiece = endNum - startNum + 1;
			// 가장 많이 가져갈 수 있을 것으로 예상되는 사람으로 갱신
			if (maxExpectPiece < expectPiece) {
				maxExpectPiece = expectPiece;
				maxExpectPiecePerson = i;
			}

			// 이미 누군가가 가져간 조각을 제외하고 가져감
			int receivePiece = 0;
			for (int j = startNum; j <= endNum; j++) {
				if (rollCake[j] == 0) {
					rollCake[j] = i;
					receivePiece++;
				}
			}
			
			// 가장 많이 가져간 사람으로 갱신
			if (maxReceivePiece < receivePiece) {
				maxReceivePiece = receivePiece;
				maxReceivePiecePerson = i;
			}
		}
		System.out.println(maxExpectPiecePerson);
		System.out.println(maxReceivePiecePerson);
	}
}
