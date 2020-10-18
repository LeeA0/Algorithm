package baekjoon.silver;

import java.util.LinkedList;
import java.util.Scanner;

//백준_수이어가기_2635_실버5
public class BOJ_2635_수이어가기 {
	static int N, max;
	static LinkedList<Integer> save, max_save;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		save = new LinkedList<Integer>();
		// 수가 1이면 최대 개수가 1이다.
		max = 0;
		max_save = new LinkedList<Integer>();
		for (int i = N; i >= 1; i--) {
			save.clear();
			save.add(N);
			save.add(i);
			// 이미 첫번째 숫자와 두번째 숫자가 들어가있음
			int cnt = 2;

			// 배열에 원소 넣기
			while (true) {
				int temp = save.get(cnt - 2) - save.get(cnt - 1);
				if (temp < 0) {
					break;
				}
				save.add(temp);
				cnt++;
			}
			if (cnt > max) {
				max = cnt;
				max_save.clear();
				for (int j = 0; j < save.size(); j++) {
					max_save.add(save.get(j));
				}
			}
		}
		System.out.println(max);
		for (int s : max_save) {
			System.out.print(s + " ");
		}
	}
}
