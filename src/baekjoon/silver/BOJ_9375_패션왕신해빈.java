package baekjoon.silver;

import java.util.LinkedList;
import java.util.Scanner;

//백준_패션왕신해빈_9375_실버3
public class BOJ_9375_패션왕신해빈 {
	static int T, N;
	// 옷 저장
	static String[][] clothes;
	// 옵션 저장
	static LinkedList<String> optionlist;
	// 개수 저장
	static int[] num;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			clothes = new String[N][2];
			optionlist = new LinkedList<String>();

			for (int i = 0; i < N; i++) {
				clothes[i][0] = scan.next();
				clothes[i][1] = scan.next();
				if (!optionlist.contains(clothes[i][1])) {
					optionlist.add(clothes[i][1]);
				}
			}

			num = new int[optionlist.size()];

			// 가짓수별 개수 세기
			for (int i = 0; i < optionlist.size(); i++) {
				for (int j = 0; j < clothes.length; j++) {
					if (optionlist.get(i).equals(clothes[j][1])) {
						num[i]++;
					}
				}
			}

			// 해빈이가 옷을 입을 수 있는 날짜
			// = ((가짓수별 개수 중에 한 개 뽑음 +(전부 안뽑는 경우의 수 :1))*...* -(모든 가짓수별 옷을 하나도 안뽑음 : 1)
			// = (nC1+1)*(nC1+1)*...*(nC1+1) - 1 
			// = (가짓수별 개수+1)*(가짓수별 개수+1)*...*(가짓수별 개수+1) - 1
			int answer = 1;
			for (int i = 0; i < num.length; i++) {
				answer = answer * (num[i] + 1);
			}

			answer--;
			System.out.println(answer);
		}
	}
}
