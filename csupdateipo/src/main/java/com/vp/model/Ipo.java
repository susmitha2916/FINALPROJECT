package com.vp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ipo")
public class Ipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id;
	private String company_name;
	private int stock_id;
	private int price_per_share;
	private int no_of_shares;
	private String remarks;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public int getPrice_per_share() {
		return price_per_share;
	}
	public void setPrice_per_share(int price_per_share) {
		this.price_per_share = price_per_share;
	}
	public int getNo_of_shares() {
		return no_of_shares;
	}
	public void setNo_of_shares(int no_of_shares) {
		this.no_of_shares = no_of_shares;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
