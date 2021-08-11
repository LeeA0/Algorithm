package programmers.level1;

// Programmers_위클리_1주차_level1
public class Programmers_위클리_1주차 {
	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;
		System.out.println(solution(price, money, count));
	}
	// price가 3이고, count가 4인 경우 요금
	// = 3+6+9+12 = 3(1+2+3+4) = 3(4*5/2) = 30
	// => price가 a, count가 b일 떄 -> a*(b(b+1)/2
	public static long solution(int price, int money, int count) {
		long answer = (long) price * count * (count + 1) / 2 - money;
		// 요금이 money보다 커서 모자란 금액이 있으면 그걸 반환, 돈이 충분하면 0반환
		return answer > 0 ? answer : 0;
	}
}
