package team15.fft.model;
//Contributing authors: S Pathan, A Shafith

import java.time.LocalDate;


public class Transaction {
	LocalDate Date;
	String Description;
	Money amount;
	// instead of String its Buyer  
	Buyer buyer;
	String Category;
	public Transaction(LocalDate Date,String Description,Money amount,Buyer buyer,String Category) {
		this.Date = Date;
		this.Description = Description;
		this.amount = amount;
		this.buyer = buyer;
		this.Category = Category;
	}
	
	public LocalDate getDate() {
		return Date;
	}
	public String getDescription(){
		return Description;
	}
	
	public Money getAmount(){
		return amount;
	}
	// instead of String its Buyer 
	public Buyer getBuyer(){
		return buyer;
	}
	
	public String getCategory(){
		return Category;
	}
	
	public String toString() {
		String val = " " +Date + " " + Description + " " + amount + " " + buyer.getName() + " " + Category;
		return 	val;
			
	}
	
}
