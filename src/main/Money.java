package main;

public class Money {
	Double debit;
	Double credit;
	Double Balance;
	public Money (Double debit,Double credit,Double Balance) {
		this.debit = debit;
		this.credit = credit;
		this.Balance = Balance;
	}
	
	public Double getDebit() {
		return debit;
	}
	
	public Double getCredit() {
		return credit;
	}
	
	public Double getBalance() {
		return Balance;
	}
	
	public String toString() {
		String val = " " +  debit + " "  + credit + " " + Balance;
		return val;
	}

}