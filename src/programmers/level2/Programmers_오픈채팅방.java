package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// Programmers_오픈채팅방_level2
public class Programmers_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	// 채팅방메시지를 기록할 객체
	// 유저아이디를 중심으로 닉네임이 변경되므로, 유저 아이디를 저장
	public static class Chat {
		// 유저아이디
		String userId;
		// 상태(Enter,Leave)
		String status;

		public Chat(String userId, String status) {
			this.userId = userId;
			this.status = status;
		}
	}

	public static String[] solution(String[] record) {
		// 유저 아이디와 닉네입을 
		HashMap<String, String> userIdNickname = new HashMap<>();
		// 매우 중요한 포인트....LinkedList를 쓰면 시간초과!!!!
		ArrayList<Chat> chatList = new ArrayList<>();
		for (int i = 0; i < record.length; i++) {
			// 문자를 쪼개서 status, userId, nickname으로 분리
			StringTokenizer st = new StringTokenizer(record[i]);
			String status = st.nextToken();
			String userId = st.nextToken();
			String nickname = "";
			if (st.hasMoreTokens()) {
				nickname = st.nextToken();
			}
			// 상태에 따라 동작 수행
			switch (status) {
			case "Enter":
				// 닉네임이 변경되는 시점이므로 아이디에 닉네임을 업뎃
				userIdNickname.put(userId, nickname);
				// 채팅메시지에 들어가므로 추가
				chatList.add(new Chat(userId, "님이 들어왔습니다."));
				break;
			case "Leave":
				// 채팅메시지에 들어가므로 추가
				chatList.add(new Chat(userId, "님이 나갔습니다."));
				break;
			case "Change":
				// 닉네임이 변경되는 시점이므로 아이디에 닉네임을 업뎃
				userIdNickname.put(userId, nickname);
				break;
			}
		}
		// 정답을 담는 배열
		String[] answer = new String[chatList.size()];
		for (int i = 0; i < answer.length; i++) {
			StringBuilder sb = new StringBuilder();
			// 아이디에 해당하는 닉네임을 넣어서 문장을 완성
			sb.append(userIdNickname.get(chatList.get(i).userId)).append(chatList.get(i).status);
			answer[i] = sb.toString();
		}
		return answer;
	}
}
