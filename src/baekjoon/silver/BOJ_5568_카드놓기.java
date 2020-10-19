package baekjoon.silver;
import java.util.ArrayList;
import java.util.Scanner;

//백준_카드놓기_5568_실버5
public class BOJ_5568_카드놓기 {
	static int N, K;
	static String[] card;
	static boolean[] isSelected;
	static String[] selectCard;
	static ArrayList<String> num;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K  = scan.nextInt();
		card=new String[N];
		for (int i = 0; i < N; i++) {
			card[i] = scan.next();
		}
		isSelected = new boolean[N];
		selectCard = new String[K];
		num = new ArrayList<String>();
		nPr(0);
		//System.out.println(num.toString());
		System.out.println(num.size());
	}
	
	private static void nPr(int cnt) {
		if(cnt==K) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < K; i++) {
				sb.append(selectCard[i]);
			}
			if(!num.contains(sb.toString())) {
				num.add(sb.toString());
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i]=true;
			selectCard[cnt]=card[i];
			nPr(cnt+1);
			isSelected[i]=false;
		}
	}
}
