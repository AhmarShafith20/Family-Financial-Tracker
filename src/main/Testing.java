package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Testing {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String val="/Users/shifan/Desktop/bank.xlsx";
		String val2 = "/Users/shifan/Desktop/buyer_assignment.xlsx";
		InputFiles.read(val,val2);
	       
}
}
