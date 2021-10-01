package programmers.level1;

// Programmers_위클리_8주차_level1
public class Programmers_위클리_8주차 {
	public static void main(String[] args) {
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
		System.out.println(solution(sizes));
	}

	public static int solution(int[][] sizes) {
		int width = 0, height = 0;
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] > sizes[i][1]) {
				width = Math.max(width, sizes[i][0]);
				height = Math.max(height, sizes[i][1]);
			} else {
				width = Math.max(width, sizes[i][1]);
				height = Math.max(height, sizes[i][0]);
			}
		}
		return height * width;
	}
}
