package programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class Programmers_수식최대화 {

	public static void main(String[] args) {
		String expression = "100-2145*458+12";
		System.out.println(solution(expression));
	}

	// 정답을 저장하는 변수
	static long answer = 0;
	// number: 수식의 숫자를 저장
	// operator: 수식의 연산자(-*+)를 저장
	static String[] number, operator;
	// 수식에 사용된 연산자의 종류를 저장
	static ArrayList<String> operatorOption;

	public static long solution(String expression) {
		operatorOption = new ArrayList<>();
		// 수식에 사용된 연산자의 종류를 저장
		// 해당 연산자를 포함하면 넣는다
		if (expression.contains("+")) {
			operatorOption.add("+");
		}
		if (expression.contains("-")) {
			operatorOption.add("-");
		}
		if (expression.contains("*")) {
			operatorOption.add("*");
		}

		// 수식의 숫자만 분리한다
		// *, +, -를 기준으로 자른다
		number = expression.split("[*+-]");
		// 수식의 연산자만 분리한다
		// 숫자가 1개 이상인 연산자를 ""로 바꾸고 ""로 나눈다
		operator = expression.replaceAll("[0-9]{1,}", "").split("");
		// 연산자의 우선순위를 정한다
		nPr(0, new ArrayList<String>());
		return answer;
	}

	// cnt: 연산자를 몇 개 뽑았는지 센다
	// saveOperator: 뽑은 수식의 연산자를 저장
	public static void nPr(int cnt, ArrayList<String> saveOperator) {
		// 다 뽑았으면
		if (cnt == operatorOption.size()) {
			// 연산자의 우선순위대로 계산하여 기존 값보다 큰 지 비교하여, 크면 넣는다
			answer = Math.max(answer, calc(saveOperator));
			return;
		}
		// operatorOption을 순회하여 하나를 선택해서 넣는다
		for (int i = 0; i < operatorOption.size(); i++) {
			// 이미 넣은 연산자는
			if (saveOperator.contains(operatorOption.get(i))) {
				continue;
			}
			// 선택된 연산자를 넣는다
			saveOperator.add(operatorOption.get(i));
			nPr(cnt + 1, saveOperator);
			// 다른 연산자를 선택하기위해 기존에 넣었던 연산자를 뺸다
			saveOperator.remove(operatorOption.get(i));
		}
	}

	// 연산자 우선순위대로 계산
	// saveOperator: 뽑은 수식의 연산자(우선순위 포함)
	public static long calc(ArrayList<String> saveOperator) {
		// 숫자를 빼서 계산하고 다시 넣기위해 선언
		LinkedList<Long> numberList = new LinkedList<>();
		// number에 있는 숫자를 옮김
		for (String e : number) {
			numberList.add(Long.parseLong(e));
		}
		// 연산자를 빼서 계산하고 다시 넣기위해 선언
		LinkedList<String> operatorList = new LinkedList<>();
		// operator에 있는 연산자를 옮김
		for (String e : operator) {
			operatorList.add(e);
		}
		
		// 연산자 우선순위에 따라 반복
		for (String oper : saveOperator) {
			// 처음부터 끝가지 순환하기위한 변수
			int i = 0;
			// 연산자 리스트의 크기가 0이아니고, i가 연산자 리스트의 범위를 벗어나지 않은 동안 반복
			while (operatorList.size() != 0 && i < operatorList.size()) {
				// 현재 계산을 진행하는 연산자와 같으면
				if (operatorList.get(i).equals(oper)) {
					long sum = 0;
					// 해당위치에서 해당하는 연산자에 대한 계산을 진행
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
					// 계산해준 숫자를 제거
					numberList.remove(i + 1);
					numberList.remove(i);
					// 계산완료한 숫자를 넣음
					numberList.add(i, sum);
					// 계산된 연산자 삭제
					operatorList.remove(i);
					// 연산자가 삭제됬으므로 남은 연산자가 한 칸씩 당겨진다
					// 따라서 i값을 증가 시키지 않기 위해 -1을 빼준다
					i--;
				}
				// i증가
				i++;
			}
		}
		// 최종적으로 계산된 숫자는 0인덱스에 남게된다
		return Math.abs(numberList.get(0));
	}
}
