package com.infy.auditservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.auditservice.model.Loan;
import com.infy.auditservice.service.LoanDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/loandetails")
@Api(value = "loandetails", description = "Loan Details Operations")
public class LoanDetailsController {

	@Autowired
	private LoanDetailsService loanDetailsService;

	@RequestMapping(value = "/insertLoan", method = RequestMethod.POST)
	@ApiOperation(value = "insertLoan")
	public ResponseEntity insetLoanDetails(@RequestBody Loan loan) {
		loanDetailsService.insertLoanDetails(loan);
		return new ResponseEntity("Loan Inserted Successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/getLoans/{loanAccountNumber}", method = RequestMethod.GET)
	@ApiOperation(value = "getLoansByAccount", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") }

	)
	public List<Loan> getLoansByAccountNumber(@PathVariable("loanAccountNumber") String loanAccountNumber) {
		List<Loan> listOfLoans = loanDetailsService.getLoansByLoanAccount(loanAccountNumber);
		return listOfLoans;
	}

}
