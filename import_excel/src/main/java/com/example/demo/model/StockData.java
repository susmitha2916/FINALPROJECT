package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="STOCKDATA")
public class StockData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    private String companyCode;
    private String stockExchange;
    private double pricePerShare;
    private LocalDate date;
    private LocalTime time;
	public StockData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockData(Long sid, String companyCode, String stockExchange, double pricePerShare, LocalDate date,
			LocalTime time) {
		super();
		this.sid = sid;
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.date = date;
		this.time = time;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date2) {
		this.date = date2;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "StockData [sid=" + sid + ", companyCode=" + companyCode + ", stockExchange=" + stockExchange
				+ ", pricePerShare=" + pricePerShare + ", date=" + date + ", time=" + time + "]";
	}
    
}