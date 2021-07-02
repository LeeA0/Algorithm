package programmers.level2;

// Programmers_멀쩡한사각형_level2
public class Programmers_멀쩡한사각형 {

	public static void main(String[] args) {
		int w = 100000000;
		int h = 100000000;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {
		// 계산하면서 발생하는 오버플로우를 방지하기위해 미리 형변환을 해준다
		long long_w = w;
		long long_h = h;
		// 큰 수가 앞에 가야하므로 if문으로 나눠주었다
		if (long_w > long_h) {
			// 여러번 그려본 결과 해당 공식이 나왔다
			// w*h - (w+h-gcd(w,h))
			return long_w * long_h - (long_w + long_h - getGCD(long_w, long_h));
		} else {
			return long_w * long_h - (long_w + long_h - getGCD(long_h, long_w));
		}
		// 참고용 코드
		// return long_w * long_h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
	}

	// 최대공약수 구하기
	public static long getGCD(long l, long s) {
		if (l % s == 0) {
			return s;
		}
		return getGCD(s, l % s);
	}
}
