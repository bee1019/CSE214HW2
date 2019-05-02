//Bansri Shah
//110335850

/**
 * This class represents a DeliveryListNode which will wrap the Delivery object and
 *  it has data, next node, and previous node
 * @author Bansri
 *
 */

public class DeliveryListNode {
	private Delivery data;
	private DeliveryListNode next;
	private DeliveryListNode prev;
	
	/**
	 * This is a constructor used to wrap the Delivery object in the DeliveryListNode
	 * @param initData
	 * All of the information used to create the Delivery object
	 * @throws IllegalArgumentException
	 * throwns if the Delivery object is empty or data is null
	 */
	
	public DeliveryListNode(Delivery initData) 
			throws IllegalArgumentException {
		
		if(initData != null) {
			this.data = initData;
			next = null;
			prev = null;
		}
		
		else if(initData == null) {
			throw new IllegalArgumentException("Delivery data is null. ");
		}
	}
	
	/**
	 * This is a getter method for the data
	 * @return
	 * returns the data from the delivery object
	 */
	
	public Delivery getData() {
		return this.data;
	}
	
	/**
	 * This is a setter method for the data
	 * @param data
	 * Setting the data from the delivery object
	 */
	
	public void setData(Delivery data) {
		this.data = data;
	}
	
	/**
	 * This is a getter method for the next node
	 * @return
	 * returns the reference to the next node
	 */
	
	public DeliveryListNode getNext() {
		return this.next;
	}
	
	/**
	 * This is a setter method for the next node
	 * @param next
	 * Setting the reference to the next node
	 */
	
	public void setNext(DeliveryListNode next) {
		this.next = next;
	}
	
	/**
	 * This is a getter method for the previous node
	 * @return
	 * returns the reference to the previous node
	 */
	
	public DeliveryListNode getPrev() {
		return this.prev;
	}
	
	/**
	 * This is a setter method for the previous node
	 * @param prev
	 * Setting the reference to the previous node
	 */
	
	public void setPrev(DeliveryListNode prev) {
		this.prev = prev;
	}
}
