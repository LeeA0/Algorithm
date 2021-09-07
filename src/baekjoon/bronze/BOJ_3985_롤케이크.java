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

		int[] rollCake = new int[L];

		int maxExpectPiecePerson = 0;
		int maxExpectPiece = 0;
		int maxReceivePiecePerson = 0;
		int maxReceivePiece = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int startNum = Integer.parseInt(st.nextToken());
			int endNum = Integer.parseInt(st.nextToken());

			int expectPiece = endNum - startNum + 1;
			if (maxExpectPiece < expectPiece) {
				maxExpectPiece = expectPiece;
				maxExpectPiecePerson = i;
			}

			int receivePiece = 0;
			for (int j = startNum; j < endNum; j++) {
				if (rollCake[j] == 0) {
					rollCake[j] = i;
					receivePiece++;
				}
			}
			if (maxReceivePiece < receivePiece) {
				maxReceivePiece = receivePiece;
				maxReceivePiecePerson = i;
			}
		}
		System.out.println(maxExpectPiecePerson);
		System.out.println(maxReceivePiecePerson);
	}
}
