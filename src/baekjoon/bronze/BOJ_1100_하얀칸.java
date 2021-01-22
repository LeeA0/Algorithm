package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_하얀칸_브론즈2
public class BOJ_1100_하얀칸 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] chess = new char[8][8];
		int count = 0;
		for (int i = 0; i < 8; i++) {
			chess[i]=br.readLine().trim().toCharArray();
			if(i%2==0) {
				for (int j = 0; j < 8; j+=2) {
					if(chess[i][j]=='F') {
						count++;
					}
				}
			} else {
				for (int j = 1; j < 8; j+=2) {
					if(chess[i][j]=='F') {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
