package team15.fft.model;

//Contributing authors: S Trask

import java.util.ArrayList;
import java.util.List;

public class TransactionList {
    private List<Transaction> transactions;


    public TransactionList() {
        this.transactions = new ArrayList<>();
        
    }


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }


    public boolean removeTransaction(Transaction transaction) {
        return transactions.remove(transaction);
    }


    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions); 
    }

 
    public List<Transaction> sortByCategory(String category) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().toLowerCase().equals(category.toLowerCase())) {
                result.add(transaction);
            }
        }
        return result;
    }


    public List<Transaction> sortByBuyer(Buyer buyer) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getBuyer().getName().toLowerCase().equals(buyer.getName().toLowerCase())) {
                result.add(transaction);
            }
        }
        return result;
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
