package main;

import java.time.LocalDate;


public class Transaction {
	LocalDate Date;
	String Description;
	Money amount;
	String buyer;
	String Category;
	public Transaction(LocalDate Date,String Description,Money amount,String buyer,String Category) {
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
	
	public String getBuyer(){
		return buyer;
	}
	
	public String getCategory(){
		return Category;
	}
	
	public String toString() {
		String val = " " +Date + " " + Description + " " + amount + " " + buyer + " " +Category;
		return 	val;
			
	}
	
}
