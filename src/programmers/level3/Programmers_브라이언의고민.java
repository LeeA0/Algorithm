package programmers.level3;

public class Programmers_브라이언의고민 {
	public static void main(String[] args) {
		String sentence = "SpIpGpOpNpGJqOqA";
		System.out.println(solution(sentence));
	}

	public static String solution(String sentence) {
		StringBuilder answerSb = new StringBuilder();
		StringBuilder tempSaveSb = new StringBuilder();
		int idx = 0;
		boolean flag = false;
		while (idx < sentence.length()) {
			if (Character.isUpperCase(sentence.charAt(idx))) {
				tempSaveSb.append(sentence.charAt(idx++));
				if (Character.isLowerCase(sentence.charAt(idx))) {
					char specialChar = sentence.charAt(idx);
					for (int i = idx; i < sentence.length(); i += 2) {
						if (specialChar != sentence.charAt(i)) {
							idx = i;
							break;
						}
						if (Character.isLowerCase(sentence.charAt(i + 1))) {
							flag = true;
							break;
						}
						tempSaveSb.append(sentence.charAt(i + 1));
					}
					if (flag) {
						break;
					}
				}
			} else {
				char specialChar = sentence.charAt(idx++);
				while (Character.isUpperCase(sentence.charAt(idx))) {
					tempSaveSb.append(sentence.charAt(idx++));
				}
				if (tempSaveSb.length() == 0 || specialChar != sentence.charAt(idx)) {
					flag = true;
					break;
				}
				idx++;
			}
			answerSb.append(tempSaveSb.toString()).append(" ");
			tempSaveSb.delete(0, tempSaveSb.length());
		}

		return flag ? "invalid" : answerSb.toString();
	}
}
