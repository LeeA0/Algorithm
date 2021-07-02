package programmers.level1;

// Programmers_3진법 뒤집기_level1
public class Programmers_3진법뒤집기 {
	public static void main(String[] args) {
		int n = 125;
		System.out.println(solution(n));
	}

	// 0.04ms ~ 0.05ms
	public static int solution(int n) {
		String three = getThree(n); // => Integer.toString(n,3);
		return toTen(three); // => Integer.parseInt(three,3);
	}

	// 3진법으로 변환
	// 자동으로 거꾸로 저장된다
	public static String getThree(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % 3);
			n /= 3;
		}
		return sb.toString();
	}

	// 10진법으로 변환
	public static int toTen(String n) {
		int ten = 0;
		int mul = 1;
		for (int i = n.length() - 1; i >= 0; i--) {
			ten += (n.charAt(i) - '0') * mul;
			mul *= 3;
		}
		return ten;
	}
	
	// 0.10ms ~ 1.86ms
//	public static int solution(int n) {
//		String three = Integer.toString(n,3);
//		StringBuffer sb = new StringBuffer(three);
//        three = sb.reverse().toString();
//		return Integer.parseInt(three,3);
//	}
}
