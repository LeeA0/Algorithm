package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 백준_국영수_10825_실버4
public class BOJ_10825_국영수_using_treeset {
	static class Student implements Comparable<Student> {
		String name;
		int korean;
		int english;
		int math;

		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if (this.korean != o.korean) {
				return Integer.compare(-1 * this.korean, -1 * o.korean);
			} else if (this.english != o.english) {
				return Integer.compare(this.english, o.english);
			} else if (this.math != o.math) {
				return Integer.compare(-1 * this.math, -1 * o.math);
			} else {
				return this.name.compareTo(o.name);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeSet<Student> list = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			list.add(new Student(n, k, e, m));
		}
		StringBuilder sb = new StringBuilder();
		for (Student s : list) {
			sb.append(s.name).append("\n");
		}
		System.out.print(sb);
	}
}
