package dan.list;


public class CircularList {

	Node head;
	Node tail;
	int length;
	
	public CircularList(Node n) {
		this.head = n;
		this.tail = n;
		this.length = 1;
	}

	public static Node moveThroughList(Node n, int num){
		for(int i = 0; i < num; i++){
			n = n.getNext();
		}
		return n;
	}
	
	public void addNode(Node n){
		tail.next = n;
		tail = n;
		length++;
		n.next = head;
	}

	/**
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
}
