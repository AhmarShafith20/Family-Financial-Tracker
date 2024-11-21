package team15.fft.datastore;

//Contributing authors: S Pathan

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import team15.fft.model.Money;
import team15.fft.model.Transaction;
import team15.fft.model.TransactionList;



public class InputFiles {

	public InputFiles() {
		
	}


	public static TransactionList read(String filePath) throws IOException, FileNotFoundException {
	    TransactionList list = new TransactionList();

	    FileInputStream inputStream = new FileInputStream(filePath);
	    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	    XSSFSheet sheet = workbook.getSheet("Sheet1");

	    int maxRows = sheet.getLastRowNum();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	    for (int i = 0; i <= maxRows; i++) {
	        XSSFRow row = sheet.getRow(i);
	        if (row == null) {
	            // Skip empty rows
	            continue;
	        }

	        try {
	            // Parse date
	            XSSFCell dateCell = row.getCell(0);
	            LocalDate date = (dateCell != null && dateCell.getCellType() == CellType.STRING)
	                ? LocalDate.parse(dateCell.getStringCellValue(), formatter)
	                : null;

	            // Parse description
	            XSSFCell descCell = row.getCell(1);
	            String description = (descCell != null && descCell.getCellType() == CellType.STRING)
	                ? descCell.getStringCellValue()
	                : "";

	            // Parse debit
	            XSSFCell debitCell = row.getCell(2);
	            double debit = (debitCell != null && debitCell.getCellType() == CellType.NUMERIC)
	                ? debitCell.getNumericCellValue()
	                : 0.0;

	            // Parse credit
	            XSSFCell creditCell = row.getCell(3);
	            double credit = (creditCell != null && creditCell.getCellType() == CellType.NUMERIC)
	                ? creditCell.getNumericCellValue()
	                : 0.0;

	            // Parse balance
	            XSSFCell balanceCell = row.getCell(4);
	            double balance = (balanceCell != null && balanceCell.getCellType() == CellType.NUMERIC)
	                ? balanceCell.getNumericCellValue()
	                : 0.0;

	            // Create Money object
	            Money cash = new Money(debit, credit, balance);

	            // Add transaction
	            list.addTransaction(new Transaction(date, description, cash, null, null));

	        } catch (Exception e) {
	            System.err.println("Error processing row " + i + ": " + e.getMessage());
	            // Optionally log the row for debugging
	        }
	    }

	    workbook.close();
	    return list;
	}


}