package programmers.level2;

import java.util.PriorityQueue;

// Programmers_방금그곡_level2
public class Programmers_방금그곡 {
	public static void main(String[] args) {
		String m = "ABCDEFG";
		String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		System.out.println(solution(m, musicinfos));
	}

	// '#'을 어떻게 처리할지가 관건인 문제!
	// 음악을 우선순위큐로 정렬하여 제일 우선에 있는 음악의 제목을 반환하기 위한 객체 music
	static class Music implements Comparable<Music> {
		// 입력된 순서
		int idx;
		// 재생시간
		int play_time;
		// 제목
		String subject;
		// 음
		String melody;

		public Music(int idx, int play_time, String subject, String melody) {
			this.idx = idx;
			this.play_time = play_time;
			this.subject = subject;
			this.melody = melody;
		}

		@Override
		public int compareTo(Music o) {
			// 플레이 시간이 다르면 플레이 시간이 긴 음악을 우선순위에 둠
			if (this.play_time != o.play_time) {
				return Integer.compare(o.play_time, this.play_time);
			}
			// 플레이 시간이 같으면 먼저 입력된 음악을 우선순위에 둠
			return Integer.compare(this.idx, o.idx);
		}
	}

	public static String solution(String m, String[] musicinfos) {
		// 우선순위에 맞게 정렬하면서 저장할 우선순위 큐
		PriorityQueue<Music> musics = new PriorityQueue<>();
		// C#, D#과 같은 #을 구분하기 위해 #이 들어간 음계는 소문자로 변환
		m = convert(m);

		// music들을 보면서 조건과 일치하는 음악을 찾음
		for (int i = 0; i < musicinfos.length; i++) {
			// ,단위로 음악의 정보를 쪼갬
			String[] music_string = musicinfos[i].split(",");
			// 시작시간의 시와 분을 쪼갬
			String[] start = music_string[0].split(":");
			int[] s = { Integer.parseInt(start[0]), Integer.parseInt(start[1]) };
			// 종료시간의 시와 분을 쪼갬
			String[] end = music_string[1].split(":");
			int[] e = { Integer.parseInt(end[0]), Integer.parseInt(end[1]) };
			// 분단위로 시간 계산
			if (s[0] > e[0]) {
				e[0] += 24;
			}
			if (s[1] > e[1]) {
				e[0] -= 1;
				e[1] += 60;
			}

			// 우선순위 큐에 집어넣기 위해 분리한 정보로 music 객체를 생성
			// 멜로디의 #을 소문자로 변환하여 저장
			Music music = new Music(i, (e[0] - s[0]) * 60 + e[1] - s[1], music_string[2], convert(music_string[3]));

			// 현재 음악을 재생시간만큼 재생했을 때 만들어지는 멜로디를 저장하기위한 StringBuilder
			StringBuilder sb_full_melody = new StringBuilder();

			// 재생시간만큼 재생했을 때 생성되는 멜로디를 저장
			for (int j = 0; j < music.play_time / music.melody.length(); j++) {
				sb_full_melody.append(music.melody);
			}
			sb_full_melody.append(music.melody.substring(0, music.play_time % music.melody.length()));

			// 현재 음악의 전체 멜로디에서  m과 일치하는 멜로디가 있다면 우선순위 큐에 넣음
			if (sb_full_melody.toString().contains(m)) {
				musics.offer(music);
			}

		}
		// 우선순위 큐가 비어있다면 None을 아니라면 조건에 맞는 음악으 제목을 반환
		return musics.isEmpty() ? "(None)" : musics.poll().subject;
	}

	// #이 붙은 음계를 소문자로 변형
	private static String convert(String m) {
		StringBuilder sb = new StringBuilder();
		// #은 뒤에 붙기 때문에, 편리성을 위해 뒤에서부터 반복
		for (int j = m.length() - 1; j >= 0; j--) {
			if (m.charAt(j) == '#') {
				j--;
				sb.append(Character.toLowerCase(m.charAt(j)));
			} else {
				sb.append(m.charAt(j));
			}
		}
		return sb.reverse().toString();
	}
}
