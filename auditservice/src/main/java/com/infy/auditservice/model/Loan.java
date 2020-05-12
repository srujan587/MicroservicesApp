package com.infy.auditservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Document(collection = "LoanDetails")
public class Loan {

	@Id
	@JsonProperty("id")
	private String id;
	@JsonProperty("loanAccountNumber")
	private String loanAccountNumber;
	@JsonProperty("typeOfLoan")
	private String typeOfLoan;
	@JsonProperty("loanAmount")
	private BigDecimal loanAmount;
	@JsonProperty("emi")
	private BigDecimal emi;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonProperty("created_on")
	private LocalDateTime created_on;

	public Loan() {

	}
	
	
	public Loan(String id, String loanAccountNumber, String typeOfLoan, BigDecimal loanAmount, BigDecimal emi,
			LocalDateTime created_on) {
		super();
		this.id = id;
		this.loanAccountNumber = loanAccountNumber;
		this.typeOfLoan = typeOfLoan;
		this.loanAmount = loanAmount;
		this.emi = emi;
		this.created_on = created_on;
	}


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

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getEmi() {
		return emi;
	}

	public void setEmi(BigDecimal emi) {
		this.emi = emi;
	}

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	

}
