//Bansri Shah
//110335850

import java.util.Scanner;

/**
 * This class is the driver class which has 3 lists, option (given by user), and listType (current list)
 * It prints all the options and the user must input one of the letters in order to do the action
 * It will continue to loop until user input "Q" (case insensitive) in order to quit the program 
 * using a switch statement
 * It uses a try-catch block to bring exceptions to attention and notify the user of the error
 * @author Bansri
 *
 */

public class OilChangeManager {
	public static void main (String [] args) 
			throws EndOfListException, IllegalArgumentException, NullPointerException {
		DeliveryList listA = new DeliveryList();
		DeliveryList listB = new DeliveryList();
		DeliveryList listC = new DeliveryList();
		Delivery del = null;
		char listType = 'A';
		
		String option = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to Bee's Delinquent Dollar Delivery Scheduler!");
		
		boolean loop = true;
		while(loop) {
		try {
			System.out.println();
			System.out.println("Menu:");
			System.out.println("\tA) Add a Delivery After Cursor");
			System.out.println("\tR) Remove Delivery At Cursor");
			System.out.println("\tX) Cut Cursor");
			System.out.println("\tV) Paste After Cursor");
			System.out.println("\tH) Cursor to Head");
			System.out.println("\tT) Cursor to Tail");
			System.out.println("\tF) Cursor Forward");
			System.out.println("\tB) Cursor Backward");
			System.out.println("\tS) Switch Delivery Lists");
			System.out.println("\tP) Print current list");
			System.out.println("\tQ) Quit");
			System.out.println();
			System.out.print("Please select an option: ");
			option = scan.next();
			option = option + scan.nextLine();
			option = option.toUpperCase();
			char opChar = option.charAt(0);
			
			switch(opChar) {
			
			case 'A':
				System.out.print("Please enter a source: ");
				String source = scan.next();
				source = source + " " + scan.nextLine();
				System.out.print("Please enter a destination: ");
				String dest = scan.next();
				dest = dest + " " + scan.nextLine();
				System.out.print("Please enter any special instructions: ");
				String instruction = scan.next();
				instruction = instruction + " " + scan.nextLine();
				
				Delivery newDelivery = new Delivery(source, dest, instruction);
				
				if(listType == 'A') {
					listA.insertAfterCursor(newDelivery);
					System.out.println("Order inserted.");
				}
				else if(listType == 'B') {
					listB.insertAfterCursor(newDelivery);
					System.out.println("Order inserted.");
				}
				else if(listType == 'C') {
					listC.insertAfterCursor(newDelivery);
					System.out.println("Order inserted.");
				}
				
				break;
				
			case 'R':
				if(listType == 'A') {
					Delivery temp = listA.getCursor();
					listA.removeCursor();
					System.out.println("Delivery to " + temp.getDest() + " removed.");
				}
				else if(listType == 'B') {
					Delivery temp = listB.getCursor();
					listB.removeCursor();
					System.out.println("Delivery to " + temp.getDest() + " removed.");
				}
				else if(listType == 'C') {
					Delivery temp = listC.getCursor();
					listC.removeCursor();
					System.out.println("Delivery to " + temp.getDest() + " removed.");
				}
				
				break;
				
			case 'X':
				if(listType == 'A') {
					del = listA.getCursor();
					listA.removeCursor();
					System.out.println("Cursor is cut.");
				}
				else if(listType == 'B') {
					del = listB.getCursor();
					listB.removeCursor();
					System.out.println("Cursor is cut.");
				}
				else if(listType == 'C') {
					del = listC.getCursor();
					listC.removeCursor();
					System.out.println("Cursor is cut.");
				}

				break;
				
			case 'V':
				if(listType == 'A') {
					if(del != null) {
					listA.insertAfterCursor(del);
					System.out.println("Delivery pasted.");
					del = null;
					}
					else {
						throw new NullPointerException("Delivery is null. Please cut cursor first.");
					}
				}
				else if(listType == 'B') {
					if(del != null) {
						listB.insertAfterCursor(del);
						System.out.println("Delivery pasted.");
						del = null;
						}
						else {
							throw new NullPointerException("Delivery is null. Please cut cursor first.");
						}
				}
				else if(listType == 'C') {
					if(del != null) {
						listC.insertAfterCursor(del);
						System.out.println("Delivery pasted.");
						del = null;
						}
						else {
							throw new NullPointerException("Delivery is null. Please cut cursor first.");
						}
				}

				break;
				
			case 'H':
				if(listType == 'A') {
					listA.resetCursorToHead();
					System.out.println("Cursor is at head.");
				}
				else if(listType == 'B') {
					listB.resetCursorToHead();
					System.out.println("Cursor is at head.");
				}
				else if(listType == 'C') {
					listC.resetCursorToHead();
					System.out.println("Cursor is at head.");
				}

				break;
				
			case 'T':
				if(listType == 'A') {
					listA.CursorToTail();
					System.out.println("Cursor is at tail.");
				}
				else if(listType == 'B') {
					listB.CursorToTail();
					System.out.println("Cursor is at tail.");
				}
				else if(listType == 'C') {
					listC.CursorToTail();
					System.out.println("Cursor is at tail.");
				}

				break;
				
			case 'F':
				if(listType == 'A') {
					listA.cursorForward();
					System.out.println("Cursor moved forward.");
				}
				else if(listType == 'B') {
					listB.cursorForward();
					System.out.println("Cursor moved forward.");
				}
				else if(listType == 'C') {
					listC.cursorForward();
					System.out.println("Cursor moved forward.");
				}
				
				break;
				
			case 'B':
				if(listType == 'A') {
					listA.cursorBackward();
					System.out.println("Cursor moved backward.");
				}
				else if(listType == 'B') {
					listB.cursorBackward();
					System.out.println("Cursor moved backward.");
				}
				else if(listType == 'C') {
					listC.cursorBackward();
					System.out.println("Cursor moved backward.");
				}

				break;
				
			case 'S':
				System.out.print("Please select a list to look at (A, B, C): ");
				String currList = scan.next();
				currList =  currList + scan.nextLine();
				currList = currList.toUpperCase();
				listType = currList.charAt(0); 
				System.out.println("List " + listType + " selected.");
				
				break;
				
			case 'P':
				if(listType == 'A') {
					System.out.println("List A: ");
					System.out.println(listA.toString());
				}
				else if(listType == 'B') {
					System.out.println("List B: ");
					System.out.println(listB.toString());
				}
				else if(listType == 'C') {
					System.out.println("List C: ");
					System.out.println(listC.toString());
				}

				break;
				
			case 'Q':
				System.out.println("\nNext time, try UPS!");
				System.exit(opChar);
				
			default: 
				System.out.println("Invalid option. Please select an option listed above.");
				break;
			}
		}
		
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		catch(EndOfListException ex) {
			System.out.println(ex.getMessage());
		}
		catch(NullPointerException ne) {
			System.out.println(ne.getMessage());
		}
	}
	}
}
