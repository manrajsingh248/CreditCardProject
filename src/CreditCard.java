public class CreditCard {
	private String idnum;
	private Money Balance;
	
	public CreditCard( String i) {
		this.idnum = i;
		this.Balance = new Money("$0.00");
	}
	
	public CreditCard() {
		this.idnum = "000";
		this.Balance = new Money("$0.00");
	}
	
	public String getIDnum() {
		return this.idnum;	
	}
	
	public Money getBalance() {
		return this.Balance;	
	}

	public void setBalance(Money payamt ) {
		this.Balance = payamt;
	}
	
	public boolean payCard(Money payamt) {
		if( this.Balance.compareMoney( payamt) == 0 || this.Balance.compareMoney( payamt) == 1) {
			this.setBalance(this.Balance.subtractMoney(payamt));
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "";
	}
}
