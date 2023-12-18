package datastructure.linkedlist;

public class DoublyLinkedList<T> {
	private DoublyListNode<T> headNode;
	private DoublyListNode<T> tailNode;
	private int size = 0;
	
	public <K extends T> DoublyLinkedList() {
		this.headNode = null;
		this.size = 0;
	}
	public DoublyLinkedList(T[] dataArray){
		buildFromArray(dataArray);
	}
	private void buildFromArray(T[] dataArray) {
		for(T item: dataArray) {
			DoublyListNode<T> node = new DoublyListNode<T>(item);
			if(headNode==null) {
				headNode = tailNode = node;
			}else {
				tailNode.setNext(node);
				node.setPrevious(tailNode);
				tailNode = node;
			}
			size++;
		}
	}
	
	public void insertAtBeginning(T item) {
		if(headNode==null && tailNode==null) {
			tailNode = headNode = new DoublyListNode<>(item);
		}else {
			DoublyListNode<T> node = new DoublyListNode<T>(item);
			node.setNext(headNode);
			headNode.setPrevious(node);
			headNode = node;
		}
		size++;
	}
	
	public void insertAtEnd(T item) {
		if(headNode==null && tailNode==null) {
			tailNode=headNode=new DoublyListNode<T>(item);
		}else {
			DoublyListNode<T> node = new DoublyListNode<T>(item);
			tailNode.setNext(node);
			node.setPrevious(tailNode);
			tailNode = node;
		}
		size++;
	}
	
	public void insertAtIndex(T item, int index) {
		if(index<0) {
			throw new IndexOutOfBoundsException();
		}else if(headNode==null && tailNode==null && index>0) {
			throw new IndexOutOfBoundsException();
		}else if(index==0) {
			insertAtBeginning(item);
		}else if(index == size()) {
			insertAtEnd(item);
		}else {
			DoublyListNode<T> current = headNode;
			while(index>1) {
				current = current.getNext();
				index--;
			}
			DoublyListNode<T> node = new DoublyListNode<T>(item);
			node.setNext(current.getNext());
			current.setNext(node);
		}
		size++;
	}
	
	public int size() {
		int size = this.size;
		return size;
	}
	
	@Override
	public String toString() {
		DoublyListNode<?> currentNode = this.headNode;
		String output = "[";
		while(currentNode != null) {
			output = output + "{" + currentNode.getData() + "}";
			currentNode = currentNode.getNext();
		}
		output = output+"]";
		return output;
	}
	
	public static void main(String[] args) {
		stringDataTester();
	}
	private static void stringDataTester() {
		String[] dataArray = {"A", "B", "C"};
		DoublyLinkedList<String> linkedList =  new DoublyLinkedList<String>(dataArray);
		System.out.println(linkedList);
		linkedList.insertAtBeginning("D");
		System.out.println(linkedList);
		linkedList.insertAtEnd("E");
		System.out.println(linkedList);
		linkedList.insertAtIndex("FF",4);
		System.out.println(linkedList);
		linkedList.insertAtIndex("GG",6);
		System.out.println(linkedList);
		linkedList.insertAtIndex("HH",0);
		System.out.println(linkedList);
		linkedList.insertAtIndex("II",2);
		System.out.println(linkedList);
		linkedList.insertAtIndex("JJ",-1);
		System.out.println(linkedList);
	}
}
