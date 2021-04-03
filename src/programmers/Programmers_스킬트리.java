package programmers;

public class Programmers_스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		System.out.println(solution(skill, skill_trees));
	}

//	// 코드는 간결하지만, 시간은 더 오래걸림
//	public static int solution(String skill, String[] skill_trees) {
//		int answer = 0;
//
//		for (String skill_tree : skill_trees) {
//			// skill에 포함되어있지 않은 문자를 전부 지우고, 순서가 지켜졌는지 파악하기 위해 indexOf를 사용한다.
//			// indexOf: 문자의 첫 글자의 인덱스
//			if (skill.indexOf(skill_tree.replaceAll("[^" + skill + "]", ""))==0) {
//				answer++;
//			}
//		}
//
//		return answer;
//	}
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		// 스킬트리 목록 중 하나를 뽑는다
		for (String skill_tree : skill_trees) {
			// 스킬순서의 인덱스
			int idx = 0;
			// 스킬순서를 지켰는지 여부
			boolean success = true;
			for (int i = 0; i < skill_tree.length(); i++) {
				// 만약 현재 위치가 스킬순서에 있는 스킬이면, 배우고 다음 스킬순서로 이동
				if (skill_tree.charAt(i) == skill.charAt(idx)) {
					idx++;
					// 만약 모든 스킬 순서를 지켰다면 더 볼 필요가 없으므로 break
					if (idx >= skill.length()) {
						break;
					}
				} 
				// 스킬 순서와 맞지 않지만 현재 스킬이 스킬순서에 있는 경우 스킬순서가 잘못 된것이므로 false
				else if (skill.contains(Character.toString(skill_tree.charAt(i)))) {
					success = false;
				}
			}
			// 정상적인 스킬 순서로 배웠다면 +1
			if (success) {
				answer++;
			}
		}

		return answer;
	}
}
