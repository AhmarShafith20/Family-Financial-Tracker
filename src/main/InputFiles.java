package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
//sheet name and no assigned buyers and credit is null 
public class InputFiles {

	public InputFiles() {
		
	}
	
	public static void read(String filePath,String buyerAssignment)  throws IOException, FileNotFoundException {
		
		FileInputStream buyer = new FileInputStream(buyerAssignment);
		XSSFWorkbook book = new XSSFWorkbook(buyer);
		XSSFSheet page = book.getSheet("Sheet1");
		int buyer_max_rows = page.getLastRowNum();
		
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		
		FileInputStream inputStream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		
		int max_rows = sheet.getLastRowNum();
		for (int i =0;i<=max_rows;i++) {
			
			XSSFRow rows = sheet.getRow(i);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate date = LocalDate.parse(rows.getCell(0).getStringCellValue(),formatter);
			String description = rows.getCell(1).getStringCellValue();
			Double debit = rows.getCell(2).getNumericCellValue();
			Double credit=0.0;
			if(rows.getCell(3)!=null) {
				
			
			credit = rows.getCell(3).getNumericCellValue(); 
			}
			Double balance = rows.getCell(4).getNumericCellValue(); 
			String Buyer ="";
			String category = "";
			Money cash = new Money(debit,credit,balance); 
			Buyer buyerObj = null; //Creating buyer object AHMAR SHAAFITH
			for (int j=0;j<=buyer_max_rows;j++) {
				XSSFRow buyer_rows = page.getRow(j);
				if (description.contains(buyer_rows.getCell(0).getStringCellValue())) {
					Buyer = buyer_rows.getCell(1).getStringCellValue();
					category = buyer_rows.getCell(2).getStringCellValue();
					//System.out.println("x: " + buyer +" "+category );
					buyerObj = new Buyer(buyer); //Assigning variables in the buyerObject AHMAR SHAFITH
					break;
				}
			}
			list.add(new Transaction(date,description,cash,Buyer,category));

			//list of transaction for that buyer AHMAR SHAFITH
			if (buyer != null) {
                buyer.addTransaction(new Transaction(date, description, cash, buyerObj, category));
            }
		}
		workbook.close();
		book.close();
		System.out.println(list);
		
	}
}
