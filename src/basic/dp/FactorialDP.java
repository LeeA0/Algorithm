package basic.dp;

public class FactorialDP {

	public static void main(String[] args) {
		long[] fact = new long[21];
		fact[0]=1;
		fact[1]=1;
		for (int i = 2; i < 21; i++) {
			fact[i]=i*fact[i-1];
		}
		System.out.println(fact[20]);
	}

}
