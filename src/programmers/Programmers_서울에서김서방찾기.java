package programmers;

//Programmers_서울에서김서방찾기_level1
public class Programmers_서울에서김서방찾기 {
	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		System.out.println(solution(seoul));
	}
	public static String solution(String[] seoul) {
		int i;
		// 배열을 탐색한다
		for (i = 0; i < seoul.length; i++) {
			// Kim을 찾으면 멈춤
			if(seoul[i].equals("Kim")) {
				break;
			}
		}
        return "김서방은 "+i+"에 있다";
    }
}
