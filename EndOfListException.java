//Bansri Shah
//110335850

/**
 * This class represents the EndOfListException extending the Exception super class
 * @author Bansri
 *
 */
public class EndOfListException extends Exception{
	
	/**
	 * This constructor creates the exception that's being called in other classes
	 * @param msg
	 * Depending when this exception is thrown, a special message will be sent to the constructor and 
	 * printed in the driver class
	 */
	public EndOfListException(String msg) {
		super(msg);
	}
}
