package main;

import java.util.ArrayList;
import java.util.List;

//@author AHMAR SHAFITH 3763634 

public class Buyer {
	private String name;
	private List<String> categories; 
    private List<Transaction> transaction; 

	    
    public Buyer(String name) {
        this.name = name;
        this.categories = new ArrayList<>();
        this.transaction = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<Transaction> getTransactions() {
        return transaction;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public void addTransaction(Transaction transactions) {
        transaction.add(transactions);
    }

    @Override
    public String toString() {
        return "Buyer: " + name + ", Categories: " + categories.size() + ", Transactions: " + transaction.size();
    }
}


