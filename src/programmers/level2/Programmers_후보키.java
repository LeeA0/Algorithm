package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;

public class Programmers_후보키 {

	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println(solution(relation));
	}

	// 후보키를 저장할 리스트
	static ArrayList<boolean[]> candidateKeyList;

	public static int solution(String[][] relation) {
		candidateKeyList = new ArrayList<boolean[]>();
		// 열의 개수
		int size = relation[0].length;
		// 제일 작은 범위부터 선택해 저장하기 위해 1부터 시작
		for (int i = 1; i <= size; i++) {
			// 열 중 i개만큼 선택
			nCr(0, 0, new boolean[size], i, relation);
		}
		// 후보키의 개수 반환
		return candidateKeyList.size();
	}

	public static void nCr(int cnt, int start, boolean[] isSelect, int R, String[][] relation) {
		// R개 선택했으면
		if (cnt == R) {
			// 후보키이고, 현재있는 후보키와 중복이 없으면
			if (isCandidate(isSelect, relation) && !isContain(isSelect)) {
				// 후보키에 추가
				// 그냥 isSelect를 넣으면 주소참조로 추후에 isSelect의 값이 변경됬을 때 같이 변경되므로 clone해서 넣어줌
				candidateKeyList.add(isSelect.clone());
			}
			return;
		}
		// 맨 처음부터 하나씩 선택
		for (int i = start; i < isSelect.length; i++) {
			// i 선택
			isSelect[i] = true;
			// 다음으로 이동
			nCr(cnt + 1, i + 1, isSelect, R, relation);
			// i 선택 해제
			isSelect[i] = false;
		}
	}

	// 현재 고른 열이 후보키인지 판별하는 함수
	public static boolean isCandidate(boolean[] isSelect, String[][] relation) {
		// 후보키로 대조하기위한 데이터를 저장하는 hashSet
		HashSet<String> saveData = new HashSet<String>();
		// 전체 행을 조회
		for (int i = 0; i < relation.length; i++) {
			// 데이터를 한 문장으로 만들기 위한 StringBuilder
			StringBuilder sb = new StringBuilder();
			// 선택된 열의 데이터를 하나의 문장으로 합침
			for (int j = 0; j < isSelect.length; j++) {
				if (isSelect[j]) {
					sb.append(relation[i][j]);
				}
			}
			// 합친 문장이 저장된 데이터 중 같은게 있다면 중복 발생으로 후보키가 아님
			if (saveData.contains(sb.toString())) {
				return false;
			}
			// 중복이 아니라면 데이터에 저장
			saveData.add(sb.toString());
		}
		// 중복없이 전부 저장됬다면 후보키
		return true;
	}

	// 후보키가 최소성을 만족하는지 판별하기위한 함수
	public static boolean isContain(boolean[] isSelect) {
		// 저장된 후보키를 조회
		for (boolean[] candidate : candidateKeyList) {
			// 현재 후보키에 선택된 값이 포함되는 지 여부
			boolean flag = true;
			// 후보키로 선택된 열 조회
			for (int i = 0; i < isSelect.length; i++) {
				// 만약 한 개라도 후보키는 true인데, 선택된 값이 false라면 해당 선택된 키는 현재 후보키에 종속되지않음
				if (candidate[i] && !isSelect[i]) {
					flag = false;
					break;
				}
			}
			// 만약 선택된 키가 종속이면 true반환
			if (flag) {
				return true;
			}
		}
		// 모든 후보키를 조회했을 때 종속이 아니면 false반환
		return false;
	}
}
