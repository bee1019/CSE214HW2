//Bansri Shah
//110335850

/**
 * This class represents a DeliveryList which has 3 nodes: head, tail, and cursor
 * @author Bansri
 *
 */

public class DeliveryList {
	private DeliveryListNode head;
	private DeliveryListNode tail;
	private DeliveryListNode cursor;
	
	/**
	 * This is a constructor used to create a DeliveryList, it doesn't take anything in
	 * however, it sets the 3 nodes to null
	 */
	
	public DeliveryList() {
		head = null;
		tail = null;
		cursor = null;
	}
	
	/**
	 * This method counts the total number of deliveries in the list
	 * @return
	 * returns the number of deliveries
	 */
	
	public int numDeliveries() {
		DeliveryListNode nodePtr = head;
		int count = 0;
		
		while(nodePtr != null) {
			count++;
			nodePtr = nodePtr.getNext();
		}
		
		return count;
	}
	
	/**
	 * This method gets the delivery at the location of the cursor
	 * @return
	 * returns the delivery located at the cursor
	 */
	
	public Delivery getCursor() {
		if(cursor == null) {
			return null;
		}
		
		else {
			return cursor.getData();
		}
	}
	
	/**
	 * This method moves the cursor to the location of the head in the linked list
	 */
	
	public void resetCursorToHead() {
		if(head != null) {
			cursor = head;
		}
		
		else if(head == null) {
			cursor = null;
		}
	}
	
	/**
	 * This method moves the cursor to the location of the tail in the linked list
	 */
	
	public void CursorToTail() {
		if(tail != null) {
			cursor = tail;
		}
		
		else if(tail == null) {
			cursor = null;
		}
	}
	
	/**
	 * This method moves the cursor forward one node in the linked list
	 * @throws EndOfListException
	 * exception thrown if cursor was already at tail
	 * @throws IllegalArgumentException
	 * exception thrown if cursor and tail are null
	 */
	
	public void cursorForward() 
	throws EndOfListException, IllegalArgumentException {
		if(cursor == tail) {
			throw new EndOfListException("Cursor is at the tail of list.");
		}
		else if(cursor == null && tail == null) {
			throw new IllegalArgumentException("Cursor and tail are null.");
		}
		else {
			cursor = cursor.getNext();
		}
	}
	
	/**
	 * This method moves the cursor backward one node in the linked list
	 * @throws EndOfListException
	 * exception thrown if cursor was already at head
	 * @throws IllegalArgumentException
	 * exception thrown is cursor and head are null
	 */
	
	public void cursorBackward() 
	throws EndOfListException, IllegalArgumentException {
		if(cursor == head) {
			throw new EndOfListException("Cursor is at the head of list.");
		}
		else if(cursor == null && head == null) {
			throw new IllegalArgumentException("Cursor and head are null.");
		}
		else {
			cursor = cursor.getPrev();
		}
	}
	
	/**
	 * This method inserts by linking a new delivery wrapped in a node after the cursor
	 * @param newDelivery
	 * new delivery object is taken in and then wrapped in a delivery node
	 * @throws IllegalArgumentException
	 * exception thrown is the new delivery object is empty or null
	 */
	
	public void insertAfterCursor(Delivery newDelivery) 
	throws IllegalArgumentException {
		if(newDelivery == null) {
			throw new IllegalArgumentException("Delivery object is null.");
		}
		
		else if (newDelivery != null && cursor != null && numDeliveries() == 1) {
			DeliveryListNode newNode = new DeliveryListNode(newDelivery);
			cursor.setNext(newNode);
			newNode.setPrev(cursor);
			tail = newNode;
		}
		else if(newDelivery != null && cursor != null && numDeliveries() >= 2 && cursor != tail) {
			DeliveryListNode newNode = new DeliveryListNode(newDelivery);
			
			DeliveryListNode afterCur = cursor.getNext();
			cursor.setNext(newNode);
			newNode.setPrev(cursor);
			newNode.setNext(afterCur);
			afterCur.setPrev(newNode);
			
			if(cursor == head && numDeliveries() == 3) {
				cursor = head.getNext();
			}
		}
		else if(newDelivery != null && cursor != null && numDeliveries() >= 2 && cursor == tail) {
			appendToTail(newDelivery);
		}
		
		else if(newDelivery != null && cursor == null) {
			DeliveryListNode newNode = new DeliveryListNode(newDelivery);
			head = newNode;
			cursor = newNode;
			tail = newNode;
		}
	}
	
	/**
	 * This method inserts by linking a new delivery wrapped in a node after the tail only
	 * if the cursor is at tail already
	 * @param newDelivery
	 * new delivery object is taken in and then wrapped in a delivery node
	 * @throws IllegalArgumentException
	 * exception thrown is the new delivery object is empty or null
	 */
	
	public void appendToTail(Delivery newDelivery) 
	throws IllegalArgumentException {
		if(newDelivery == null) {
			throw new IllegalArgumentException("Delivery object is null.");
		}
		else if(newDelivery != null && tail != null) {
			DeliveryListNode newNode = new DeliveryListNode(newDelivery);
			cursor.setNext(newNode);
			newNode.setPrev(cursor);
			tail = newNode;
		}
		else if(newDelivery != null && tail == null) {
			DeliveryListNode newNode = new DeliveryListNode(newDelivery);
			head = newNode;
			tail = newNode;
			cursor = newNode;
		}
	}
	
	/**
	 * This method is used to remove the delivery object located at the cursor
	 * @return
	 * returns the object located at the cursor
	 * @throws EndOfListException
	 * exception thrown if cursor is null
	 */
	
	public Delivery removeCursor() 
	throws EndOfListException {
		Delivery temp = new Delivery();
		if(cursor == null) {
			throw new EndOfListException("Cursor is null.");
		}
		else if(cursor == tail && cursor != head) {
			temp = cursor.getData();
			cursor = cursor.getPrev();
			tail = cursor;
			cursor.setNext(null);
			return temp;
		}
		else if(cursor == head && cursor != tail) {
			temp = cursor.getData();
			cursor = cursor.getNext();
			head = cursor;
			return temp;
		}
		else if(cursor == head && cursor == tail && head == tail) {
			temp = cursor.getData();
			head = null;
			tail = null;
			cursor = null;

			System.out.println("\n\nCursor: " + cursor.getData().toString() + "\n\n");
			return temp;
		}
		else {
			temp = cursor.getData();
			cursor.getNext().setPrev(cursor.getPrev());
			cursor.getPrev().setNext(cursor.getNext());
			cursor = cursor.getNext();
			return temp;
		}
	}
	
	/**
	 * 
	 */
	
	public String toString() 
	throws NullPointerException {
		DeliveryListNode node = head;
		String result = "";
		if(node == null) {
			throw new NullPointerException("List is empty.");
		}
		
		System.out.println("-------------------------------------------------------------------------\n");
		while(node != null) {
			result = result + node.getData().toString() + "\n";
			node = node.getNext();
		}
		result = result + "-------------------------------------------------------------------------";
		return result;
		
	}
}
