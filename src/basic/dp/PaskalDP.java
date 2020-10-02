package basic.dp;

import java.util.Arrays;

public class PaskalDP {

	public static void main(String[] args) {
		int N = 21;
		//지그재그 배열
		long[][] c = new long[N][];
		c[0]=new long[1];
		c[0][0]=1;
		c[1]=new long[2];
		c[1][0]=1;
		c[1][1]=1;
		for (int i = 1; i < N; i++) {
			c[i]=new long[i+1];
			c[i][0]=1;
			c[i][i]=1;
			for (int j = 1; j < i; j++) {
				c[i][j]=c[i-1][j-1]+c[i-1][j];
			}
			System.out.println(Arrays.toString(c[i]));
		}
	}
}
