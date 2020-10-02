package basic.simplelinkedlist;

public class SimpleLinkedList {
	private Node head;

	public void addFirstNode(String data) {
		//원래 첫번째였던 헤드의 주소 값을 링크에 넣어주면 됨.
		Node newNode = new Node(data, head);
		//헤드를 새로 생성한 노드로 설정
		head = newNode;
	}
	
	public void printList() {
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data+" ");
		}
		System.out.println();
	}
}
