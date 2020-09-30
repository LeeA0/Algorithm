package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

//백준_나머지_3052_브론즈2
public class BOJ_3052_나머지 {
	static HashSet<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			int a = Integer.parseInt(br.readLine().trim());
			list.add(a%42);
		}
		System.out.println(list.size());
	}
}