package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

//PQ로 한번 풀어보기
//SW_수정이의타일자르기_1812_D5
public class Solution_1812_수정이의타일자르기 {
	static int T, N, M;
	static int[] S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			S = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(S);

			int answer = 0;
			LinkedList<int[]> saveSquare = new LinkedList<int[]>();

			for (int n = N - 1; n >= 0; n--) {
				boolean canIn = false;
				int SI = (int) Math.pow(2, S[n]);
				for (int i = 0; i < saveSquare.size(); i++) {
					int width = saveSquare.get(i)[0];
					int height = saveSquare.get(i)[1];
					if (width >= SI && height >= SI) {
						saveSquare.remove(i);
						canIn = true;
						if (width != SI && height!=SI) {
							saveSquare.add(new int[] { width - SI, height });
							saveSquare.add(new int[] { SI, height - SI });
						}else if(width == SI) {
							saveSquare.add(new int[] { width, height-SI });
						}else if(height ==SI) {
							saveSquare.add(new int[] { width-SI, height });
						}
						break;
					}
				}
				if (!canIn) {
					// 새 M 타일 꺼냄
					answer++;
					if (M != SI) {
						// 자르고 나머지 저장
						saveSquare.add(new int[] { M - SI, M });
						saveSquare.add(new int[] { SI, M - SI });
					}
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
