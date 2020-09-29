package basic.dfs;

import java.util.Stack;

public class St1_StackAPITest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		System.out.println(stack.size()+"//"+stack.isEmpty());
		stack.push("이동욱");
		stack.push("이지아");
		stack.push("김태희");
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.peek());//top에 있는 걸 출력, 꺼내진않음.
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());//스택이 빈 상태에서 pop해서 그럼.
	}

}
