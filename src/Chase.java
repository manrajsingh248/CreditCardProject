public class Chase extends CreditCard{
	private Money servicefee;
	
	public Chase ( String i, Money s) {
		super(i);
		this.servicefee = s;
	}

	public Chase () {	
		super();
		this.servicefee = new Money("$15.00");	
	}
	
	public Money getServiceFee() {
		return this.servicefee;
	}
	
	public void chargeCard(Money payamt){
		Money newbalance = getBalance().addMoney(payamt).addMoney(servicefee);
		super.setBalance(newbalance);
	}
		
	public String toString() {
		return super.toString() + "Card: Chase" + 
		"\nService Fee: " + this.servicefee + "\nBalance: " + 
		this.getBalance();
	}
}
