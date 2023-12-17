package datastructure.linkedlist;
/**
 * 
 * @param <T>
 * 
 * Supported operations 
 * insert
 */
public class SinglyLinkedList<T> {
	private SinglyListNode<T> headNode;
	private int size = 0;
	public SinglyLinkedList(){
		this.headNode=null;
	}
	/**
	 * Constructor to build singly linked list from array
	 * @param data
	 */
	public <K extends T> SinglyLinkedList(K[] data) {
		buildFromArray(data);
	}
	
	private <K extends T> SinglyListNode<? extends T> buildFromArray(T[] dataArray) {
		SinglyListNode<T> node;
		for(T data: dataArray) {
			node = new SinglyListNode<>(data, null);
			insertAtEnd(node);
		}
		return headNode; 
	}
	
	public int size() {
		return this.size;
		/*
		 * int size = 0; SinglyListNode<?> current = headNode; while(current!=null) {
		 * size++; current = current.getNext(); } return this.size = size;
		 */
	}
	/*
	 * Traverses the linked list from head to end node and returns
	 * string representation of data
	 */
	@Override
	public String toString() {
		SinglyListNode<?> currentNode = this.headNode;
		String output = "[";
		while(currentNode != null) {
			output = output + "{" + currentNode.getData() + "} ";
			currentNode = currentNode.getNext();
		}
		output = output+"]";
		return output;
	}
	private SinglyListNode<T> insertAtBeginning(SinglyListNode<T> node) {
		if(node==null) {
			return headNode;
		}else if(headNode==null) {
			headNode=node;
			size++;
		}else {
			node.setNext(headNode);
			headNode = node;
			size++;
		}
		return headNode;
	}
	private SinglyListNode<T> insertAtEnd(SinglyListNode<T> node) {
		SinglyListNode<T> current = headNode;
		if(node==null) {
			return headNode;
		}else if(headNode==null) {
			headNode = node;
			size++;
		}else {
			while(current.getNext()!=null) {
				current = current.getNext();
			}
			current.setNext(node);
			size++;
		}
		return headNode;
	}
	public SinglyListNode<T> insert(SinglyListNode<T> node, int index) throws IndexOutOfBoundsException{

		SinglyListNode<T> current = headNode;
		if(index<0) {
			throw  new IndexOutOfBoundsException("Index cannnot be negative. Specified value of index : "+index);
		} else if(index==0) {
			this.insertAtBeginning(node);
		}else if(headNode==null && index>0) {
			throw new IndexOutOfBoundsException(index);
		}else if(index==0) {
			this.insertAtBeginning(node);
		}else if(index==this.size()) {
			this.insertAtEnd(node);
		}else if(index>this.size()) {
			throw new IndexOutOfBoundsException("List size is : " + this.size() + ", Index supplied is : "+ index);
		}else if(headNode!= null && index > 0) {
			while(index>1) {
				current = current.getNext();
				index--;
			}
			node.setNext(current.getNext());
			current.setNext(node);
		}
		return headNode;
	}
	
	public SinglyListNode<T> remove(int index){
		if(headNode==null || index<0 || index>size) {
			throw new IndexOutOfBoundsException();
		}else if(index==0) {
			removeFirst();
		}else {
			removeIndex(index);
		}
		return headNode;
	}
	
	private SinglyListNode<T> removeIndex(int index) {
		SinglyListNode<T> current = headNode;
		while(index > 1) {
			current = current.getNext();
			index--;
		}
		SinglyListNode<T> indexedNode = current.getNext();
		current.setNext(indexedNode.getNext());
		indexedNode.setNext(null);
		size--;
		return headNode;
	}
	private SinglyListNode<T> removeFirst(){
		SinglyListNode<T> current = headNode;
		if(headNode==null) {
			throw new IndexOutOfBoundsException();
		}
		headNode = headNode.getNext();
		current.setNext(null);
		size--;
		return headNode;
	}
	
	public void removeMatched(T item) {
		SinglyListNode<T> current = headNode;
		SinglyListNode<T> previous = null;
		while(current!=null) {
			if(current.getData().equals(item)) {
				if(previous!=null) {
					previous.setNext(current.getNext());
					current.setNext(null);
					return;
				}else {
					current = current.getNext();
					headNode = current;
				}
				
			}else {
				previous = current;
				current = current.getNext();
			}
		}
	}
	
	public SinglyListNode<T> search(T item){
		SinglyListNode<T> current = headNode;
		while(current!=null) {
			if(current.getData().equals(item)) {
				return current;
			}else {
				current = current.getNext();
			}
		}
		return null;
	}
	
	public int index(T item) {
		SinglyListNode<T> current = headNode;
		int index = -1;
		while(current!=null) {
			index++;
			if(current.getData().equals(item)) {
				return index;
			}else {
				current = current.getNext();
				if(current==null) {
					index = -1;
				}
			}
		}
		return index;
	}
	
	public void clear() {
		headNode = null;
		size = 0;
	}
	public static void main(String[] args) {
		integerDataTester();
		stringDataTester();
	}
	private static void stringDataTester() {
		String[] dataArray = {"A", "B", "C"};
		SinglyLinkedList<String> linkedList =  new SinglyLinkedList<>(dataArray);
		System.out.println(linkedList);
		linkedList.insertAtBeginning(new SinglyListNode<String>("EE", null));
		System.out.println(linkedList);
		linkedList.insertAtEnd(new SinglyListNode<String>("FF", null));
		System.out.println(linkedList);
		linkedList.insert(new SinglyListNode<String>("GG", null), 4);
		System.out.println(linkedList);
		//linkedList.insert(new SinglyListNode<String>("HH", null), 10);
		//System.out.println(linkedList);
		linkedList.insert(new SinglyListNode<String>("II", null), 0);
		System.out.println(linkedList);
		linkedList.insert(new SinglyListNode<String>("JJ", null), linkedList.size());
		System.out.println(linkedList);
		//linkedList.insert(new SinglyListNode<String>("KK", null), linkedList.size()+1);
		//System.out.println(linkedList);
		linkedList.remove(5);
		System.out.println(linkedList);
		linkedList.remove(0);
		System.out.println(linkedList);
		linkedList.remove(linkedList.size());
		System.out.println(linkedList);
	}
	private static void integerDataTester() {
		Integer[] dataArray = {1, 2, 3, 4, 6, 7 , 8, 9};
		SinglyLinkedList<Integer> linkedList =  new SinglyLinkedList<>(dataArray);
		System.out.println(linkedList);
		linkedList.insertAtBeginning(new SinglyListNode<Integer>(101, null));
		System.out.println(linkedList);
		linkedList.insertAtEnd(new SinglyListNode<Integer>(202, null));
		System.out.println(linkedList);
		linkedList.insert(new SinglyListNode<Integer>(303, null), 4);
		System.out.println(linkedList);
		linkedList.insert(new SinglyListNode<Integer>(404, null), 10);
		System.out.println(linkedList);
		linkedList.insert(new SinglyListNode<Integer>(505, null), 0);
		System.out.println(linkedList);
		linkedList.insert(new SinglyListNode<Integer>(606, null), linkedList.size());
		System.out.println(linkedList);
		System.out.println(linkedList.search(404));
		System.out.println(linkedList.search(11111));
		System.out.println(linkedList.search(6));
		System.out.println(linkedList.index(404));
		System.out.println(linkedList.index(11111));
		System.out.println(linkedList.index(6));
		linkedList.removeMatched(404);
		System.out.println(linkedList);
		linkedList.removeMatched(1287);
		System.out.println(linkedList);
		linkedList.removeMatched(505);
		System.out.println(linkedList);
		linkedList.removeMatched(606);
		System.out.println(linkedList);
		/*
		 * linkedList.insert(new SinglyListNode<Integer>(707, null),
		 * linkedList.size()+1); System.out.println(linkedList);
		 */
	}
}
