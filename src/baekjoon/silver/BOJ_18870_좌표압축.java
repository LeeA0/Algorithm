package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

//백준_좌표압축_18870_실버2
public class BOJ_18870_좌표압축 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		TreeSet<Integer> tree = new TreeSet<Integer>();
		int[] numlist = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			tree.add(num);
			numlist[i]=num;
		}
		
		// 각 숫자와 인덱스값 저장
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		Iterator<Integer> iter = tree.iterator();
		int i=0;
		while(iter.hasNext()) {
			hash.put(iter.next(),i);
			i++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < N; j++) {
			sb.append(hash.get(numlist[j])).append(" ");
		}
		System.out.println(sb);
	}
}
