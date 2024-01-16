import java.util.Scanner;
public class TestCreditCard {

	public static void main(String[] args) {
		
		CreditCard[] myCards = new CreditCard[3];
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("Welcome to Credit Card mania! \n\nAs a reminder be sure to include the"
				+ " $ sign before writing any dollar amount \nand formatting it in decimal dollar"
				+ " form. \nClick the enter/return key to get started! \n\n ");
		
		scanner.nextLine();
		
		System.out.print("Enter a three digit id for your Chase Credit Card: ");
		String idnum1 = scanner.nextLine();
		
		System.out.print("Enter service fee amount for your Chase Credit Card: ");
		String fee1 = scanner.nextLine();
		
		myCards[ 0 ] = new Chase( idnum1, new Money(fee1));
		
		
		System.out.print("\nEnter a three digit id for your TD Credit Card: ");
		String idnum2 = scanner.nextLine();
		
		System.out.print("Enter interest level for your TD Credit Card: ");
		int interest2 = scanner.nextInt();
		
		myCards[ 1 ] = new TD(idnum2, interest2);
		
		
		System.out.print("\nEnter a three digit id for Discover Credit Card: ");
		String idnum3 = scanner.nextLine();
		
		scanner.nextLine();
		System.out.print("Enter service fee amount for your Discover Credit Card: ");
		String fee3 = scanner.nextLine();
		myCards[ 2 ] = new Discover(idnum3, new Money(fee3));
		
	
		System.out.print( "\nPrinting all cards in array, first time\n" );
		printCards( myCards );
		
	
		System.out.print("Enter an amount you want to charge the Chase and TD Card: ");
		String chargeAmount = scanner.nextLine();
		((Chase)myCards[ 0 ]).chargeCard( new Money(chargeAmount) );
		((TD)myCards[ 1 ]).chargeCard( new Money(chargeAmount) );

	
		System.out.print( "\nPrinting all cards in array, second time\n" );
		printCards( myCards );


		
		System.out.print("Enter an amount to pay balance on Chase card: ");
		String payAmount = scanner.nextLine();
		
		while(true) {
			if(payAmount.equals("quit") || payAmount.equals("exit)")) {
				break;
			}
			
			if (myCards [0].payCard(new Money (payAmount))) {
				System.out.println("Payment sucessful on Chase Card. New balance is " + myCards[0].getBalance() + "\n");
				break;
			} else {
				System.out.print("Sorry, max payment can only be " + myCards[0].getBalance() + "\n");
				System.out.print("Enter an amount to pay balance on Chase Card: "); 
				payAmount = scanner.nextLine();
			}
		}
	
	
		

		System.out.print("Enter the amount you want to charge your Discover card: ");
		chargeAmount = scanner.nextLine();
		((Discover)myCards[ 2 ]).chargeCard( new Money(chargeAmount) );
		
		
		// *******************
		// send array to printCards() method for printing
		System.out.println( "Printing all cards in array, third time\n" );
		printCards( myCards );
		
		
		// *******************
		// attempt to pay $350.00 to card 1
		// print card 1 toString() after payment attempt if successful
		// we will pay an amount greater than the balance, so this will NOT work
		
		System.out.print("Enter an amount to pay balance on TD card: ");
		payAmount = scanner.nextLine();
		
		while(true) {
			if(payAmount.equals("quit") || payAmount.equals("exit)")) {
				break;
			}
			
			if (myCards [1].payCard(new Money (payAmount))) {
				System.out.println("Payment sucessful on TD card. New balance is " + myCards[1].getBalance() + "\n");
				break;
			} else {
				System.out.print("Sorry, max payment can only be " + myCards[1].getBalance() + "\n");
				System.out.print("Enter an amount to pay balance on TD card: "); 
				payAmount = scanner.nextLine();
			}
		}
		
		scanner.close();

		// *******************
		// send array to printCards() method for printing
		System.out.println( "Printing all cards in array, fourth time\nFinal Balance on all cards: \n" );
		printCards( myCards );
	}

 // ends main() method
	
	
	public static void printCards( CreditCard[] cardarray ) {
	
		String msg = "";
		
		for( int i = 0; i < cardarray.length; i++ ) {
		
			// call toString() for each CreditCard object in array
			msg += cardarray[ i ] + "\n\n";
		}
		
		msg += "***************************\n";
		System.out.println( msg );
		
	} // ends printCards() method
	
} // ends class