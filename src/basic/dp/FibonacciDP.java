package basic.dp;

public class FibonacciDP {

	public static void main(String[] args) {
		long[] fb = new long[93];
		fb[0]=0;
		fb[1]=1;
		for (int i = 2; i < 93; i++) {
			fb[i]=fb[i-1]+fb[i-2];
			//?
			System.out.println(1.0*fb[i-1]/fb[i]);
		}
	}
}
