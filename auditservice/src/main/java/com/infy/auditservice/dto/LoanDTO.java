package com.infy.auditservice.dto;

import java.time.LocalDateTime;

import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="LoanDetails")
public class LoanDTO {

	@Id
	private String id;	
	private String loanAccountNumber;
	private String typeOfLoan;
	private Decimal128 loanAmount;
	private Decimal128 emi;
	private LocalDateTime  created_on;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}
	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}
	public String getTypeOfLoan() {
		return typeOfLoan;
	}
	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}
	public Decimal128 getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Decimal128 loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Decimal128 getEmi() {
		return emi;
	}
	public void setEmi(Decimal128 emi) {
		this.emi = emi;
	}
	public LocalDateTime getCreated_on() {
		return created_on;
	}
	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}
	
	
}
