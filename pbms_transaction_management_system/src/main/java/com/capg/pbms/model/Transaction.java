package com.capg.pbms.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_table")
public class Transaction {
	
	@Id
	private String transId;
	private String transAccountId;
	private String transType;
	private Double transAmount;
	private String transOption;
	private LocalDate transDate;
	private String transFrom;
	private String transTo;
	private Double transClosingBalnace;
	
	public Transaction() {
	
	}


	public Transaction(String transId, String transAccountId, String transType, Double transAmount, String transOption,
			LocalDate transDate, String transFrom, String transTo, Double transClosingBalnace) {
		super();
		this.transId = transId;
		this.transAccountId = transAccountId;
		this.transType = transType;
		this.transAmount = transAmount;
		this.transOption = transOption;
		this.transDate = transDate;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.transClosingBalnace = transClosingBalnace;
	}


	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getTransAccountId() {
		return transAccountId;
	}

	public void setTransAccountId(String transAccountId) {
		this.transAccountId = transAccountId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public Double getTransAmount() {
		return transAmount;
	}


	public void setTransAmount(Double transAmount) {
		this.transAmount = transAmount;
	}


	public String getTransOption() {
		return transOption;
	}

	public void setTransOption(String transOption) {
		this.transOption = transOption;
	}

	public LocalDate getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}

	public String getTransFrom() {
		return transFrom;
	}

	public void setTransFrom(String transFrom) {
		this.transFrom = transFrom;
	}

	public String getTransTo() {
		return transTo;
	}

	public void setTransTo(String transTo) {
		this.transTo = transTo;
	}

	public Double getTransClosingBalnace() {
		return transClosingBalnace;
	}

	public void setTransClosingBalnace(Double transClosingBalnace) {
		this.transClosingBalnace = transClosingBalnace;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", transAccountId=" + transAccountId + ", transType=" + transType
				+ ", transAmount=" + transAmount + ", transOption=" + transOption + ", transDate=" + transDate
				+ ", transFrom=" + transFrom + ", transTo=" + transTo + ", transClosingBalnace=" + transClosingBalnace
				+ "]";
	}
	
	
	
	
	
    
}
