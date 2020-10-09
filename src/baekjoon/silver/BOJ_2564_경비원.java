package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준_경비원_2564_실버1
public class BOJ_2564_경비원 {
	static int width, height, N, dongdir, dongdist, sum;
	static LinkedList<int[]> storelist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine().trim());

		storelist = new LinkedList<int[]>();

		// 가게 위치 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			storelist.add(new int[] { dir, dist });
		}

		// 동근이 위치 입력
		st = new StringTokenizer(br.readLine().trim(), " ");
		dongdir = Integer.parseInt(st.nextToken());
		dongdist = Integer.parseInt(st.nextToken());

		//거리계산
		for (int i = 0; i < N; i++) {
			int storedir = storelist.get(i)[0];
			int storedist = storelist.get(i)[1];

			//동근이 방향이 1,2,3,4일 때
			switch (dongdir) {
			case 1:
				//가게 방향이 1,2,3,4일 때
				switch (storedir) {
				case 1:
					sum += Math.abs(dongdist - storedist);
					break;
				case 2:
					int dist1 = dongdist + height + storedist;
					int dist2 = (width - dongdist) + (width - storedist) + height;
					sum += Math.min(dist1, dist2);
					break;
				case 3:
					sum += dongdist + storedist;
					break;
				case 4:
					sum += (width - dongdist) + storedist;
					break;
				}
				break;
			case 2:
				switch (storedir) {
				case 1:
					int dist1 = dongdist + height + storedist;
					int dist2 = (width - dongdist) + (width - storedist) + height;
					sum += Math.min(dist1, dist2);
					break;
				case 2:
					sum += Math.abs(dongdist - storedist);
					break;
				case 3:
					sum += dongdist + (height - storedist);
					break;
				case 4:
					sum += (width - dongdist) + (height - storedist);
					break;
				}
				break;
			case 3:
				switch (storedir) {
				case 1:
					sum += dongdist + storedist;
					break;
				case 2:
					sum += (height-dongdist) + storedist;
					break;
				case 3:
					sum += Math.abs(dongdist - storedist);
					break;
				case 4:
					int dist1 = dongdist + width + storedist;
					int dist2 = (height - dongdist) + (height - storedist) + width;
					sum += Math.min(dist1, dist2);
					break;
				}
				break;
			case 4:
				switch (storedir) {
				case 1:
					sum += dongdist + (width-storedist);
					break;
				case 2:
					sum += (height-dongdist) + (width - storedist);
					break;
				case 3:
					int dist1 = dongdist + width + storedist;
					int dist2 = (height - dongdist) + (height - storedist) + width;
					sum += Math.min(dist1, dist2);
					break;
				case 4:
					sum += Math.abs(dongdist - storedist);
					break;
				}
				break;
			}
		}
		System.out.println(sum);
	}
}
