package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

public class Programmers_수식최대화 {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}

	static long answer = 0;
	static String[] number, operator;
	static ArrayList<String> operatorOption;

	public static long solution(String expression) {
		operatorOption = new ArrayList<>();
		if (expression.contains("+")) {
			operatorOption.add("+");
		}
		if (expression.contains("-")) {
			operatorOption.add("-");
		}
		if (expression.contains("*")) {
			operatorOption.add("*");
		}

		number = expression.split("[*+-]");
		operator = expression.replaceAll("[0-9]{1,}", "").split("");
		System.out.println(Arrays.toString(operator));
		nPr(0, new ArrayList<String>());
		return answer;
	}

	public static void nPr(int cnt, ArrayList<String> saveOperator) {
		if (cnt == 3) {
			answer = Math.max(answer, calc(saveOperator));
			return;
		}
		for (int i = 0; i < operatorOption.size(); i++) {
			if (saveOperator.contains(operatorOption.get(i))) {
				continue;
			}
			saveOperator.add(operatorOption.get(i));
			nPr(cnt + 1, saveOperator);
			saveOperator.remove(operatorOption.get(i));
		}
	}

	public static long calc(ArrayList<String> saveOperator) {
		LinkedList<Integer> numberList = new LinkedList<>();
		for (String e : number) {
			numberList.add(Integer.parseInt(e));
		}
		LinkedList<String> operatorList = new LinkedList<>();
		for (String e : operator) {
			operatorList.add(e);
		}

		for (String oper : saveOperator) {
			for (int i = 0; i < operatorList.size(); i++) {
				if (operatorList.get(i).equals(oper)) {
					int sum = 0;
					switch (operatorList.get(i)) {
					case "+":
						sum = numberList.get(i) + numberList.get(i + 1);
						break;
					case "-":
						sum = numberList.get(i) - numberList.get(i + 1);
						break;
					case "*":
						sum = numberList.get(i) * numberList.get(i + 1);
						break;
					}
				}
			}
		}
		return numberList.get(0);
	}
}
