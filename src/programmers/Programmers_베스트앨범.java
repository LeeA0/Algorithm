package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Programmers_베스트앨범 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] genres = new String[N];
		int[] plays = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			genres[i] = st.nextToken();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			plays[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(solution(genres, plays)));
	}

	// 한 장르에 속한 노래와 관련된 객체
	static class Playlist {
		// 한 장르의 총 재생 수
		int totalPlay;
		// 한 장르에 포함된 노래의 인덱스 리스트
		ArrayList<Integer> idxList;

		// 초기 생성자
		public Playlist() {
			this.totalPlay = 0;
			this.idxList = new ArrayList<>();
		}
	}

	static int[] solution(String[] genres, int[] plays) {
		// 장르를 키, 장르에 속한 노래와 관련된 객체를 값으로 갖는 map을 선언
		HashMap<String, Playlist> map = new HashMap<>();
		// 장르가 순서대로 담긴 배열을 조회
		for (int i = 0; i < genres.length; i++) {
			// 해당 key값이 map에 등록되어 있지 않으면
			if (!map.containsKey(genres[i])) {
				// 새로운 장르를 추가하고, 그 장르에 속한 노래를 담을 객체를 생성
				map.put(genres[i], new Playlist());
			}
			// 해당 장르에 대한 playlist를 불러온다
			Playlist temp = map.get(genres[i]);
			// 해당 장르의 총 재생 수에 해당 노래의 재생 수 를 더한다
			temp.totalPlay += plays[i];
			// 해당 장르의 노래 리스트에 해당 노래를 추가한다
			temp.idxList.add(i);
			// 업데이트 된 playlist정보로 교체해준다
			map.replace(genres[i], temp);
		}
		// key를 순환하면서 playlist의 노래 인덱스 리스트를 재생수 순으로 정렬한다
		for (String key : map.keySet()) {
			map.get(key).idxList.sort((o1, o2) -> Integer.compare(plays[o2], plays[o1]));
		}
		// 정답을 저장할 list를 선언
		ArrayList<Integer> answerList = new ArrayList<>();

		// key값을 총 재생 수 순으로 정렬
		Object[] keyset = map.keySet().toArray();
		Arrays.sort(keyset, (o1, o2) -> Integer.compare(map.get(o2).totalPlay, map.get(o1).totalPlay));
		
		// 총 재생 수가 높은 장르 순서대로 재생 수가 높은 최대 2곡을 뽑아 정답 리스트에 추가한다
		for (Object key : keyset) {
			Playlist temp = map.get(key);
			int length = temp.idxList.size() < 2 ? temp.idxList.size() : 2;
			for (int i = 0; i < length; i++) {
				answerList.add(temp.idxList.get(i));
			}
		}
		// list의 값을 answer배열로 이동
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}
}
