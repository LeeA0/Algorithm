package programmers;

// Programmers_키패드누르기_level1
public class Programmers_키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}

	// 키패드의 위치
	static int[][] keypad = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
			{ 2, 2 } };

	public static String solution(int[] numbers, String hand) {
		// 초기 왼손 엄지, 오른손 엄지의 위치
		int[] left = { 3, 0 }, right = { 3, 2 };

		// 문자를 붙이기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			// 1,4,7인 경우 왼손 클릭
			switch (numbers[i]) {
			case 1:
			case 4:
			case 7:
				left = keypad[numbers[i]];
				sb.append("L");
				break;
			// 3,6,9인 경우 오른손 클릭
			case 3:
			case 6:
			case 9:
				right = keypad[numbers[i]];
				sb.append("R");
				break;
			// 2,5,8,0인 경우 거리 계산
			default:
				int leftDist = getDist(left, numbers[i]);
				int rightDist = getDist(right, numbers[i]);
				// 왼손이 더 가까울 때
				if (leftDist < rightDist) {
					left = keypad[numbers[i]];
					sb.append("L");
				} 
				// 오른손이 더 가까울 때
				else if (leftDist > rightDist) {
					right = keypad[numbers[i]];
					sb.append("R");
				} 
				// 거리가 같을 때 무슨 손잡이인지에 따라 다름
				else {
					if ("left".equals(hand)) {
						left = keypad[numbers[i]];
						sb.append("L");
					} else {
						right = keypad[numbers[i]];
						sb.append("R");
					}
				}
				break;
			}
		}

		return sb.toString();
	}

	// 키패드와 손가락과의 거리 구하기
	public static int getDist(int[] finger, int target) {
		return Math.abs(finger[0] - keypad[target][0]) + Math.abs(finger[1] - keypad[target][1]);
	}
}
