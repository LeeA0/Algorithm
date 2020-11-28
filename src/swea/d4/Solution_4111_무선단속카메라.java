package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

//SW_무선 단속 카메라_4111_D4
public class Solution_4111_무선단속카메라 {
	static int T, N, K, ans;
	static int[] dist;
	static TreeSet<Integer> camera = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			camera.clear();
			N = Integer.parseInt(br.readLine().trim());
			K = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				camera.add(Integer.parseInt(st.nextToken()));
			}
			ArrayList<Integer> camera2 = new ArrayList<>();
			for (int c : camera) {
				camera2.add(c);
			}
			dist = new int[camera.size() - 1];
			for (int i = 0; i < dist.length; i++) {
				dist[i] = camera2.get(i + 1) - camera2.get(i);
			}
			Arrays.sort(dist);
			ans = 0;
			for (int i = 0; i < camera.size() - K; i++) {
				ans += dist[i];
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
