package programmers.level2;

import java.util.LinkedList;

// Programmers_캐시_level2
public class Programmers_캐시 {
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
		System.out.println(solution(cacheSize, cities));
	}

	/*
	 * 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용
	 * LRU란? 가장 오래 참조되지않은 공간을 우선으로 사용
	 * => cacheSize=3, data=1,2,3,1,4,5
	 * 1| | 
	 * 1|2| 
	 * 1|2|3
	 * 2|3|1 => 이미 1이 캐싱되어있으므로 1이 가장 최신으로 참조되었다
	 * 4|3|1 => 가장 오랫동안 참조되지않은 2의 자리에 4가 들어감
	 * 4|5|1
	 * 
	 */
	public static int solution(int cacheSize, String[] cities) {
		// 실행시간
		int answer = 0;
		// 캐싱공간
		// 삭제했을 때 ArrayList보다 빠르고 배열보다 객체를 지우고 당기는 게 편리한 LinkedList사용
		LinkedList<String> cache = new LinkedList<String>();
		// 전체 도시 조회
		for (int i = 0; i < cities.length; i++) {
			// 대소문자 구분 안하므로 전부 소문자로 변경
			String city = cities[i].toLowerCase();
			// 만약 해당 도시가 이미 캐싱되어있으면
			if (cache.contains(city)) {
				// cache hit이므로 실행시간은 1
				answer += 1;
				// 가장 최근에 참조됬으므로 캐싱되어있는 데이터를 삭제하고
				cache.remove(city);
				// 다시 넣어 최근에 참조되었다는 표시를 해줌
				cache.add(city);
			}
			// 캐싱되어있지않다면
			else {
				// cache miss이므로 실행시간은 5
				answer += 5;
				// 캐싱공간에 넣어줌
				cache.add(city);
				// 만약 넣었을 때의 사이즈가 cacheSize보다 크면 
				if (cache.size() > cacheSize) {
					// 가장 오랫동안 참조되지않은 공간을 삭제해줌
					cache.remove(0);
				}
			}
		}
		return answer;
	}
}
