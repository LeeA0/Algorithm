package basic.simplelinkedlist;

public class SimpleLinkedListTest {

	public static void main(String[] args) {

		SimpleLinkedList list = new SimpleLinkedList();
		
		list.addFirstNode("이아름");
		list.addFirstNode("이솔");
		list.addFirstNode("김여진");
		
		list.printList();

	}
}
