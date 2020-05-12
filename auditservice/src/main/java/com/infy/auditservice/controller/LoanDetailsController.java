package com.infy.auditservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class LoanDetailsController extends LoanDetailsControllerAdvice {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LoanDetailsService loanDetailsService;

	@RequestMapping(value = "/insertLoan", method = RequestMethod.POST)
	@ApiOperation(value = "insertLoan")
	public ResponseEntity<String> insetLoanDetails(@RequestBody Loan loan) {
		logger.info("LoanDetailsController::insetLoanDetails:: Enter");
		loanDetailsService.insertLoanDetails(loan);
		logger.info("LoanDetailsController::insetLoanDetails:: Exit");
		return new ResponseEntity<String>("Loan Inserted Successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/getLoans/{loanAccountNumber}", method = RequestMethod.GET)
	@ApiOperation(value = "getLoansByAccount", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list of loans specific to loan account"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") }

	)
	public List<Loan> getLoansByAccountNumber(@PathVariable("loanAccountNumber") String loanAccountNumber) {
		logger.info("LoanDetailsController::getLoansByAccountNumber:: Enter");
		List<Loan> listOfLoans = loanDetailsService.getLoansByLoanAccount(loanAccountNumber);
		logger.info("LoanDetailsController::getLoansByAccountNumber:: Exit");
		return listOfLoans;
	}

	@RequestMapping(value = "/getAllLoans", method = RequestMethod.GET)
	@ApiOperation(value = "getAllLoans", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list of all loans"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") }

	)
	public List<Loan> getAllLoans() {
		logger.info("LoanDetailsController::getAllLoans:: Invoked");
		return loanDetailsService.getAllLoans();
	}

	@RequestMapping(value = "/deleteLoan/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "deleteLoan", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted loan"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") }

	)
	public void deleteLoan(@PathVariable("id") String id) {
		logger.info("LoanDetailsController::deleteLoan:: Enter");
		loanDetailsService.deleteLoan(id);
		logger.info("LoanDetailsController::deleteLoan:: Exit");
	}
	
	@RequestMapping(value = "/getAllPersonalLoansByAccount/{loanAccountNumber}", method = RequestMethod.GET)
	@ApiOperation(value = "getAllPersonalLoansByAccount", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list of all personal loans of a loan account"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") }

	)
	public List<Loan> getPersonalLoansByAccount(@PathVariable("loanAccountNumber") String loanAccountNumber) {
		logger.info("LoanDetailsController::getPersonalLoansByAccount:: Invoked");
		return loanDetailsService.getPersonalLoansByAccount(loanAccountNumber);
	}

}
