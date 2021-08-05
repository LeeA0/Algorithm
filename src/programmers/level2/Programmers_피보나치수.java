package programmers.level2;

// Programmers_피보나치수_level2
public class Programmers_피보나치수 {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}
	public static int solution(int n) {
		// 피보나치 수를 저장하는 배열
        int[] fib = new int[n+1];
        // 피보나치 수 1번쨰는 1이므로 초기화
        // 0은 0이므로 어처피 선언할 때 0으로 초기화 되어있음
        fib[1] = 1;
        // 2번째부터 반복문을 이용하여 구함
        for(int i = 2; i <= n; i++){
        	// n의 범위가 100,000이므로 int의 범위에서 벗어날 수 있으므로 1234567의 나머지를 저장하는 방식으로 함
            fib[i] = (fib[i-1] + fib[i-2])%1234567;
        }
        // 마지막에 최종적으로 나머지를 구함
        return fib[n]%1234567;
    }
}
