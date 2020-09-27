package basic.dfs;

public class R1_FactorialTest {

	// n!계산
	private static int factorial(int n) {
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		int N = 5;
		System.out.println(factorial(N));
	}

}
