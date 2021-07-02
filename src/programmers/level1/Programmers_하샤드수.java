package programmers.level1;

// Programmers_하샤드수_level1
public class Programmers_하샤드수 {

	public static void main(String[] args) {
		int x = 13;
		System.out.println(solution(x));
	}

	public static boolean solution(int x) {
    	int sum = 0;
    	// 나누어서 저장하는 변수
    	int tempX = x;
    	// 모든 자릿수를 더할 때까지 반복
    	// 나누기 10을 하다보면 모든 자릿수를 더했을 때 tempX가 0이 됨
    	while(tempX>0) {
    		// 10으로 나눈 나머지를 저장
    		// ex) x = 123
    		// x % 10 = 3 -> x /= 10 -> x = 12
    		// x % 10 = 2 -> x /= 10 -> x = 1
    		// x % 10 = 1 -> x /= 10 -> x = 0
    		sum += tempX%10;
    		tempX/=10;
    	}
    	// 모든 자릿 수를 더한 것으로 x가 나누어 떨어지면 0, 아니면 1
        return x%sum==0;
    }
}
