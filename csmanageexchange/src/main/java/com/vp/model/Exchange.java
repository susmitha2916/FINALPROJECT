package com.vp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_exchange")
public class Exchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id;
private String Stock_exchange;
private String brief;
private String contact_address;
private String remarks;
public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
}
public String getStock_exchange() {
	return Stock_exchange;
}
public void setStock_exchange(String stock_exchange) {
	Stock_exchange = stock_exchange;
}
public String getBrief() {
	return brief;
}
public void setBrief(String brief) {
	this.brief = brief;
}
public String getContact_address() {
	return contact_address;
}
public void setContact_address(String contact_address) {
	this.contact_address = contact_address;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
}
