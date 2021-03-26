package programmers;

// Programmers_신규아이디추천
public class Programmers_신규아이디추천 {
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(new_id));
	}
	public static String solution(String new_id) {
        String answer = "";
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = remove(new_id);
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = one_dot(new_id);
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        
        return answer;
    }
	public static String remove(String new_id) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < new_id.length(); i++) {
			char a = new_id.charAt(i);
			if(Character.isDigit(a)||Character.isLowerCase(a)||a=='-'||a=='_'||a=='.') {
				sb.append(a);
			}
		}
		return sb.toString();
	}
	
	public static String one_dot(String new_id) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < new_id.length()-1; i++) {
			if(new_id.charAt(i-1)!='.'||new_id.charAt(i)!='.') {
				sb.append(new_id.charAt(i));
			}
		}
		return sb.toString();
	}
}
