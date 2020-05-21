package com.infy.accountservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("AccountDetails")
public class Account {

	@JsonProperty("id")
	String id;

	@JsonProperty("accountNumber")
	String accountNumber;

	@JsonProperty("name")
	String name;

	@JsonProperty("age")
	int age;

	@JsonProperty("loanAmount")
	double loanAmount;

	@JsonProperty("cibilScore")
	int cibilScore;

	public Account() {

	}

	public Account(String id, String accountNumber, String name, int age, double loanAmount, int cibilScore) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.age = age;
		this.loanAmount = loanAmount;
		this.cibilScore = cibilScore;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

}
