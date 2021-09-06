package programmers.level1;

import java.util.Arrays;

public class Programmers_위클리_6주차 {

	public static void main(String[] args) {
		int[] weights = { 60, 70, 60 };
		String[] head2head = { "NNN", "NNN", "NNN" };
		System.out.println(Arrays.toString(solution(weights, head2head)));
	}

	// 복서
	public static class Boxer implements Comparable<Boxer> {
		// 복서 번호
		int idx;
		// 몸무게
		int weight;
		// 승률
		double winPercent;
		// 자신보다 몸무게가 무거운 복서를 이긴 횟수
		int winNumOverWeight;

		public Boxer(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
			this.winPercent = 0;
			this.winNumOverWeight = 0;
		}

		// 승률과 자신보다 몸무게가 무거운 복서를 이긴 횟수를 구함
		public void getWin(String head2head, int[] weights) {
			int totalMatchPeople = 0;
			for (int i = 0; i < head2head.length(); i++) {
				// 붙어보았던 사람의 수를 구함
				if (head2head.charAt(i) != 'N') {
					totalMatchPeople++;
				}
				// 이긴 사람의 수를 구함
				if (head2head.charAt(i) == 'W') {
					this.winPercent++;
					// 자신보다 몸무게가 무거운 복서를 이긴 횟수를 구함
					if (this.weight < weights[i]) {
						this.winNumOverWeight++;
					}
				}
			}
			// 한 명이상과 승부를 봤으면 인원 수 만큼 나눠주어 승률을 구함
			if (totalMatchPeople != 0) {
				this.winPercent /= totalMatchPeople;
			}
		}

		@Override
		public int compareTo(Boxer o) {
			// 승률이 높은 순 정렬
			if (this.winPercent != o.winPercent) {
				return Double.compare(o.winPercent, this.winPercent);
			}
			// 자신보다 몸무게가 무거운 복수를 많이 이긴 순 정렬
			if (this.winNumOverWeight != o.winNumOverWeight) {
				return Integer.compare(o.winNumOverWeight, this.winNumOverWeight);
			}
			// 몸무게가 높은 순 정렬
			if (this.weight != o.weight) {
				return Integer.compare(o.weight, this.weight);
			}
			// 복서 번호가 낮은 순으로 정렬
			return Integer.compare(this.idx, o.idx);
		}
	}

	public static int[] solution(int[] weights, String[] head2head) {
		// 복서들을 저장할 배열
		Boxer[] boxers = new Boxer[weights.length];
		
		for (int i = 0; i < weights.length; i++) {
			// 몸무게와 번호를 이용해서 복서 객체 생성
			boxers[i] = new Boxer(i, weights[i]);
			// 승률과 자신보다 몸무게가 무거운 복서를 이긴 횟수를 구함
			boxers[i].getWin(head2head[i], weights);
		}
		// comparable조건에 맞게 정렬
		Arrays.sort(boxers);
		
		// 복서의 번호를 순서에 맞게 저장
		int[] answer = new int[weights.length];
		for (int i = 0; i < boxers.length; i++) {
			answer[i] = boxers[i].idx + 1;
		}
		return answer;
	}
}
