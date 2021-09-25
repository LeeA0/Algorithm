package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BOJ_5430_AC_골드5
public class BOJ_5430_AC {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			String function = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arrayString = br.readLine();

			if (isError(function, n)) {
				sb.append("error").append("\n");
				continue;
			}

			int[] array = makeStringToList(arrayString, n);
			sb.append(doFunction(function, array)).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean isError(String function, int n) {
		int dCnt = 0;
		for (int i = 0; i < function.length(); i++) {
			if (function.charAt(i) == 'D') {
				dCnt++;
			}
			if (dCnt > n) {
				return true;
			}
		}
		return false;
	}

	public static int[] makeStringToList(String arrayString, int n) {
		int[] array = new int[n];
		StringTokenizer st = new StringTokenizer(arrayString.substring(1, arrayString.length() - 1), ",");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		return array;
	}

	/*
	 * LinkedList에서 지우는 연산의 시간복잡도가 O(1)이라 생각했는데,
	 * 지우는 원소를 탐색하는 과정에서 O(n)이 걸려 시간 초과가 났다
	 * 그래서 배열로 선언한 우 D연산이 들어올 때마다 시작인덱스와 끝 인덱스를 조정한다
	 */
	public static String doFunction(String function, int[] array) {
		boolean isReverse = false;
		int s = 0;
		int e = array.length - 1;
		for (int i = 0; i < function.length(); i++) {
			if (function.charAt(i) == 'R') {
				isReverse = !isReverse;
			} else {
				if (!isReverse) {
					s++;
				} else {
					e--;
				}
			}
		}
		if (s > e) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (!isReverse) {
			for (int i = s; i < e; i++) {
				sb.append(array[i]).append(",");
			}
			sb.append(array[e]);
		} else {
			for (int i = e; i > s; i--) {
				sb.append(array[i]).append(",");
			}
			sb.append(array[s]);
		}
		return sb.append("]").toString();
	}
}
