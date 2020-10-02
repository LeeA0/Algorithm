package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_딱지놀이_14696_브론즈1
public class BOJ_14696_딱지놀이 {
	static int N,a,b;
	static int[] countA,countB;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		for (int n = 0; n < N; n++) {
			countA=new int[4];
			countB=new int[4];
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			a = Integer.parseInt(st.nextToken());
			for (int i = 0; i < a; i++) {
				int temp=Integer.parseInt(st.nextToken());
				countA[temp-1]++;
			}
			
			st = new StringTokenizer(br.readLine().trim()," ");
			b = Integer.parseInt(st.nextToken());
			for (int i = 0; i < b; i++) {
				int temp=Integer.parseInt(st.nextToken());
				countB[temp-1]++;
			}//입력끝
			
			//맨 끝에 별부터 비교
			for(int i=3;i>=0;i--) {
				//같다..!
				if(countA[i]==countB[i]) {
					//마지막 모양인데 개수가 같으면 무승부
					if(i==0) {
						System.out.println("D");
					}
				}
				//A의 도형 개수가 많으면 A승
				else if(countA[i]>countB[i]) {
					System.out.println("A");
					break;
				}
				//B의 도형 개수가 많으면 B승
				else {
					System.out.println("B");
					break;
				}
			}
		}//N for문 끝
	}
}
