package programmers.level1;

// Programmers_평균구하기_level1
public class Programmers_평균구하기 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		System.out.println(solution(arr));
	}
	public static double solution(int[] arr) {
        double answer = 0;
        for(int a : arr) {
        	answer += a;
        }
        return answer/arr.length;
    }
}
