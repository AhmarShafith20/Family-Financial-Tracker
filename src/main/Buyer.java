package team15.fft.model;


//Contributing authors: A SHAFITH 

public class Buyer {
	private String name;


	    
    public Buyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Buyer: " + name + ", Categories: ";
    }
}


