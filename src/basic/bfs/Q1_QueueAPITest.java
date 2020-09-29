package basic.bfs;

import java.util.LinkedList;

public class Q1_QueueAPITest {

	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<String>();
		System.out.println(queue.size()+"//"+queue.isEmpty());
		//LinkedList는 deque라는 것도 지원해서 offer를 치고 ctrl+space하면
		//offerFirst,offerLast가 나오는데 Queue에서는 지원을 안함.
		//Queue<Integer> q = new LinkedList<Integer>(); 이걸로 확인가능.
		queue.offer("이동욱");
		queue.offer("이지아");
		queue.offer("김태희");
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());//stack의 pop과 같음
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.size()+"//"+queue.isEmpty());

	}

}
