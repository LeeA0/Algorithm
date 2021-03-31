package programmers;

public class Programmers_가운데글자가져오기 {

	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		// 문자열을 더하기 위한 stringbuilder선언
		StringBuilder sb = new StringBuilder();
		
		// 문자열의 가운데 인덱스를 계산한다
        int idx = s.length()/2;
        // 문자열의 길이가 짝수면 
        if(s.length()%2==0) {
        	// 가운데 인덱스-1에 위치한 문자를 추가한다
        	sb.append(s.charAt(idx-1));
        }
        // 가운데 인덱스에 해당하는 문자를 추가한다
        sb.append(s.charAt(idx));
        
        // string으로 반환
        return sb.toString();
    }
}
