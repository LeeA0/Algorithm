package basic.simplelinkedlist;

public class Node {

	//데이터 필드
	String data;
	
	//링크 필드
	Node link;

	public Node(String data, Node link) {
		//this(data); //->이렇게 해도 ㄱㅊ
		this.data = data;
		this.link = link;
	}
	
	public Node(String data) {
		this.data = data;
	}
}
