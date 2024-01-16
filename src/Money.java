public class Money {

	private int dollars;
	private int cents;
	
	public Money( int d, int c ) {
		
		this.dollars = d;
		this.cents = c;
	}
	
	public Money( String m ) {
		
		if( m.charAt(0) == '$' )
			this.dollars = Integer.parseInt( m.substring( 1, m.indexOf('.') ) );
		else
			this.dollars = Integer.parseInt( m.substring( 0, m.indexOf('.') ) );

		this.cents = Integer.parseInt( m.substring( m.indexOf('.') + 1, m.length() ) );
	}
	
	// default constructor
	public Money() {
		
		this.dollars = 0;
		this.cents = 0;
	}
	
	// getter methods
	public int getDollars() {
		
		return this.dollars;
	}
	
	public int getCents() {
		
		return this.cents;
	}
	
	// instance methods
	public Money addMoney( Money otherMoney ) {
		
		int newd = this.dollars + otherMoney.dollars;
		int newc = this.cents + otherMoney.cents;
		
		if( newc >= 100 ) {
			
			newc -= 100;
			newd++;
		}
		
		return new Money( newd, newc );		
		
	} // ends addMoney() method
	
	public Money subtractMoney( Money otherMoney ) {
		
		int newd = this.dollars - otherMoney.dollars;
		int newc = this.cents - otherMoney.cents;
		
		if( newc < 0 ) {
			
			newc += 100;
			newd--;
		}
		return new Money( newd, newc );
	} // ends subtractMoney() method
	
	public Money multiplyMoney( int times ) {
		
		int newd = this.dollars * times;
		int newc = this.cents * times;
		
		while( newc >= 100 ) {
			
			newc -= 100;
			newd++;
		}
		
		return new Money( newd, newc );
	} // ends multiplyMoney() method
	
	public int compareMoney( Money otherMoney ) {
		
		if( this.dollars > otherMoney.dollars )
			return 1;
		else if( this.dollars < otherMoney.dollars )
			return -1;
		else if( this.cents > otherMoney.cents )
			return 1;
		else if( this.cents < otherMoney.cents )
			return -1;
		else
			return 0;		
	} // ends compareMoney() method
	
	public String toString() {
		
		if( this.cents < 10 )
			return "$" + this.dollars + ".0" + this.cents;
		else
			return "$" + this.dollars + "." + this.cents;
	} // ends toString() method	

} // ends class