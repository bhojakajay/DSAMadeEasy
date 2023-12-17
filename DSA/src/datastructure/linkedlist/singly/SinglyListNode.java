package datastructure.linkedlist.singly;

public class SinglyListNode<T> {
	private T data;
	private SinglyListNode<T> next;
	
	public <K extends T> SinglyListNode(K data, SinglyListNode<T> next) {
		super();
		this.data = data;
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public SinglyListNode<T> getNext() {
		return next;
	}
	public void setNext(SinglyListNode<T> singlyListNode) {
		this.next = singlyListNode;
	}
}
