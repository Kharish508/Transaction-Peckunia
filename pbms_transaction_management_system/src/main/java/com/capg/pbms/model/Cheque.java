package com.capg.pbms.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cheque_table")
public class Cheque {

	@Id
    private String chequeId;
    private Integer chequeNum;
    private String accountNum;
    private Double amount;
    private String chequeHolderName;
    private String chequeBankName;
    private String chequeIFSC;
    private LocalDate chequeIssueDate;
    private String chequeStatus;
    
    public Cheque() {
	
	}

   
	public Cheque(String chequeId, Integer chequeNum, String accountNum, Double amount, String chequeHolderName,
			String chequeBankName, String chequeIFSC, LocalDate chequeIssueDate, String chequeStatus) {
		super();
		this.chequeId = chequeId;
		this.chequeNum = chequeNum;
		this.accountNum = accountNum;
		this.amount = amount;
		this.chequeHolderName = chequeHolderName;
		this.chequeBankName = chequeBankName;
		this.chequeIFSC = chequeIFSC;
		this.chequeIssueDate = chequeIssueDate;
		this.chequeStatus = chequeStatus;
	}


	public String getChequeId() {
		return chequeId;
	}


	public void setChequeId(String chequeId) {
		this.chequeId = chequeId;
	}


	public Integer getChequeNum() {
		return chequeNum;
	}


	public void setChequeNum(Integer chequeNum) {
		this.chequeNum = chequeNum;
	}


	public String getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getChequeHolderName() {
		return chequeHolderName;
	}


	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}


	public String getChequeBankName() {
		return chequeBankName;
	}


	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}


	public String getChequeIFSC() {
		return chequeIFSC;
	}


	public void setChequeIFSC(String chequeIFSC) {
		this.chequeIFSC = chequeIFSC;
	}


	public LocalDate getChequeIssueDate() {
		return chequeIssueDate;
	}


	public void setChequeIssueDate(LocalDate chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}


	public String getChequeStatus() {
		return chequeStatus;
	}


	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}


	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", chequeNum=" + chequeNum + ", accountNum=" + accountNum + ", amount="
				+ amount + ", chequeHolderName=" + chequeHolderName + ", chequeBankName=" + chequeBankName
				+ ", chequeIFSC=" + chequeIFSC + ", chequeIssueDate=" + chequeIssueDate + ", chequeStatus="
				+ chequeStatus + "]";
	}
   
    
}
