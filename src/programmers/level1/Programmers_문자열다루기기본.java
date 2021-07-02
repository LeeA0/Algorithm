package programmers.level1;

// Programmers_문자열다루기기본_level1
public class Programmers_문자열다루기기본 {
	public static void main(String[] args) {
		String s = "1234";
		System.out.println(solution(s));
	}
	public static boolean solution(String s) {
		// 길이가 4나 6이고, 숫자로만 이루어져있으면 true 아니면 false
		return (s.length()==4||s.length()==6)&&s.matches("^[0-9]*$");
    }
}
