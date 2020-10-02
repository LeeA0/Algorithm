package basic.graph;

import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */
public class G1_AdjMatrixTest {
	static int N;
	static boolean[][] adjMatrix;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		adjMatrix = new boolean[N][N];
		
		int cnt = scan.nextInt();
		for (int i = 0; i < cnt; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			//true를 [to][from]에 넣고 이 들어간걸 [from][to]에 넣음 => 양방향
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}

	}
}
