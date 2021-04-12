package programmers;

public class Programmers_멀쩡한사각형 {

	public static void main(String[] args) {
		int w = 3;
		int h = 5;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {
		return w * h - (w + h - getGCD(w, h));
	}

	public static long getGCD(int w, int h) {
		long l, s;
		if (w == h) {
			return w;
		} else if (w > h) {
			l = w;
			s = h;
		} else {
			l = h;
			s = w;
		}
		while (s > 0) {
			long temp = l;
			l = s;
			s = temp % s;
		}
		return l;
	}
}
