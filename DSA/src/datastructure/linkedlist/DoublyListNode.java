package datastructure.linkedlist;

public class DoublyListNode<T> {
	private T data;
	private DoublyListNode<T> next;
	private DoublyListNode<T> previous;
	
	public <K extends T> DoublyListNode(T item){
		this.data = item;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public DoublyListNode<T> getNext() {
		return next;
	}
	public void setNext(DoublyListNode<T> next) {
		this.next = next;
	}
	public DoublyListNode<T> getPrevious() {
		return previous;
	}
	public void setPrevious(DoublyListNode<T> previous) {
		this.previous = previous;
	}
	
	@Override
	public String toString() {
		return this.getData().toString();
	}
}
