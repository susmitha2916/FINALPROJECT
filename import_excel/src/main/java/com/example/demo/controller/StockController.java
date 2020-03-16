package com.example.demo.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CompanyStock;
import com.example.demo.model.CompanyStock;
import com.example.demo.model.StockData;
import com.example.demo.model.Summary;
import com.example.demo.repository.CompanyStockRepository;
import com.example.demo.service.StockService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@Autowired
	CompanyStockRepository companyStockRepository;
	
	@Autowired
	Summary sum;
	
	
	
	 private LocalDate toDate;
	 private LocalDate fromDate;
	 private int noOfRecord;
	 private String stockExchange;
	 
	 //post excel sheet
	
	@PostMapping("/import")
	public Summary mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

	    List<StockData> tempStockData = new ArrayList<StockData>();
	    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);

	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	    	StockData stockData = new StockData();

	        XSSFRow row = worksheet.getRow(i);

	        //stockData.setSid((long) row.getCell(0).getNumericCellValue());
	        String stockExchangeCode = row != null ? row.getCell(0).getStringCellValue() : null;
	        if(null == stockExchangeCode || stockExchangeCode.isEmpty())
	        	break;
	        
			stockData.setCompanyCode(stockExchangeCode);
	        stockData.setStockExchange(row.getCell(1).getStringCellValue());
	        stockData.setPricePerShare(row.getCell(2).getNumericCellValue());
	        
	        LocalDate localDate = row.getCell(3).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        stockData.setDate(localDate);
	        
	        String tim = row.getCell(4).getStringCellValue();	                	       
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	        LocalTime time = LocalTime.parse(tim.trim());	        
	        stockData.setTime(time);
	        
	       // System.out.println("STOCK DATA : "+stockData);
	        
	        tempStockData.add(stockData);   
	        
	        stockService.saveStock(stockData);
	      //  System.out.println("Done StockData Saved !!!!!!!!!!!!!!");
	        /////////////////////////////////////////////
	        if(i==1)
	        {
	        	fromDate=localDate;
	        }
	        else
	        {
	        	toDate=localDate;
	        }
	        
	        noOfRecord=i;
	        
	        stockExchange=row.getCell(1).getStringCellValue();
	        
	        
	    }
	    Summary summary = new Summary();
	    summary.setToDate(toDate);
	    summary.setFromDate(fromDate);
	    summary.setNoOfRecord(noOfRecord);
	    summary.setStockExchange(stockExchange);
	    sum = summary;
	    return summary;
	 }
	@GetMapping("/summary")
	public Summary summary1()
	{
	return sum;
	}
	//get list of excrel detail which is imported
	
	@GetMapping("/stockData")
	public List<StockData> getAllStockData(){
		return stockService.getAllStockData();
	}
	

	
	
}