package com.infy.payrollservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("PayrollDetails")
public class Payroll {
    @JsonProperty("id")
    String id;
    @JsonProperty("accountNumber")
    String accountNumber;
    @JsonProperty("name")
    String name;
    @JsonProperty("typeOfSalary")
    String typeOfSalary;
    @JsonProperty("income")
    Double income;
    @JsonProperty("durationOfEmployment")
    int durationOfEmployment;

    public Payroll() {
    }

    public Payroll(String id, String accountNumber, String name, String typeOfSalary, Double income, int durationOfEmployment) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.typeOfSalary = typeOfSalary;
        this.income = income;
        this.durationOfEmployment = durationOfEmployment;
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

    public String getTypeOfSalary() {
        return typeOfSalary;
    }

    public void setTypeOfSalary(String typeOfSalary) {
        this.typeOfSalary = typeOfSalary;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public int getDurationOfEmployment() {
        return durationOfEmployment;
    }

    public void setDurationOfEmployment(int durationOfEmployment) {
        this.durationOfEmployment = durationOfEmployment;
    }
}
