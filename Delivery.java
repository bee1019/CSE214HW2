//Bansri Shah
//110335850

/**
 * This class represents a Delivery which has a source, destination, and special instruction
 * @author Bansri
 *
 */
public class Delivery {
	private String source;
	private String dest;
	private String instruction;
	
	/**
	 * This is a default empty constructor used to create an instance of a Delivery
	 */
	
	public Delivery() {
		
	}
	
	/**
	 * This is a constructor used to create a Delivery object
	 * @param source
	 * Where the delivery is coming from
	 * @param dest
	 * Where the delivery is to be delivered to
	 * @param instruction
	 * Special instructions for the delivery
	 */
	
	public Delivery(String source, String dest, String instruction) {
		this.source = source;
		this.dest = dest;
		this.instruction = instruction;
	}
	
	/**
	 * This is a getter method for the source
	 * @return
	 * returns the source for this delivery
	 */
	
	public String getSource() {
		return this.source;
	}
	
	/**
	 * This is a setter method for the source
	 * @param source
	 * Setting the source for this delivery
	 */
	
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * This is a getter method for the destination
	 * @return
	 * returns the destination for this delivery
	 */
	
	public String getDest() {
		return this.dest;
	}
	
	/**
	 * This is a setter method for the destination
	 * @param dest
	 * Setting the destination for this delivery
	 */
	
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	/**
	 * This is a getter method for the instructions
	 * @return
	 * returns the instructions for this delivery
	 */
	
	public String getInstruction() {
		return this.instruction;
	}
	
	/**
	 * This is a setter method for the instructions
	 * @param instruction
	 * Setting the instructions for this delivery
	 */
	
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	/**
	 * 
	 */
	
	public String toString() {
		return "To: " + dest + " | From: " + source + "\nInstruction: " + instruction + "\n";
	}
	
	
}
