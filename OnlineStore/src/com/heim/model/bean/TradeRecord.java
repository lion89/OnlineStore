package com.heim.model.bean;

import java.util.Date;

public class TradeRecord {
	
	private int id;
	private int total;
	private Date tradeTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public TradeRecord(int total, Date tradeTime) {
		super();
		this.total = total;
		this.tradeTime = tradeTime;
	}

}
