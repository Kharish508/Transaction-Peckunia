package com.capg.pbms.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.capg.pbms.model.Slip;
import com.capg.pbms.model.Transaction;
import com.capg.pbms.service.ITransactionService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/transaction")
public class Controller {
  
	@Autowired
	ITransactionService transactionService;
	
	/****************************************************************************************************************************
	 * - Method Name : addslip 
	 * - Input Parameters : Slip slip 
	 * - Returntype : slip 
	 * - End Point Url : /addslip/{transType}
	 * -Request Method Type: PostMapping 
	 * - Author : Capgemini 
	 * - Creation Date : 23-08-2020 
	 * - Description:Adding slip transactions details to the database.
	 ****************************************************************************************************************************/
	
	@PostMapping("/addslip/{transType}")
	public ResponseEntity<Slip> creditSlip(@RequestBody Slip slip,@PathVariable String transType) throws RestClientException, URISyntaxException
	{
		return new ResponseEntity<Slip>(transactionService.addSlip(slip, transType), HttpStatus.OK);
		
	}
	
	/****************************************************************************************************************************
	 * - Method Name : getAllTransactions 
	 * - Input Parameters : Transactions 
	 * - Returntype :  List<Transaction>
	 * - End Point Url : /getalltransactions
	 * -Request Method Type: GetMapping 
	 * - Author : Capgemini 
	 * - Creation Date : 23-08-2020 
	 * - Description: Get slip transactions details from the database.
	 ****************************************************************************************************************************/
	
	
	@GetMapping("/getalltransactions")
	public ResponseEntity<List<Transaction>> getAllTransactions()
	{
		System.out.println("\n IN controller \n\n");
		return new ResponseEntity<List<Transaction>>(transactionService.getAllTransactions(), HttpStatus.OK);
		
	}
	
	/****************************************************************************************************************************
	 * - Method Name : getAllTransactionsByAccountNum 
	 * - Input Parameters : Transactions 
	 * - Returntype :  List<Transaction>
	 * - End Point Url : /getalltransactions-byaccountnum/{accountNum}")
	 * -Request Method Type: GetMapping 
	 * - Author : Capgemini 
	 * - Creation Date : 23-08-2020 
	 * - Description: Get slip transactions details from the database by account number.
	 ****************************************************************************************************************************/
	@GetMapping("/getalltransactions-byaccountnum/{accountNum}")
	public ResponseEntity<List<Transaction>>  getAllTransactionsByAccountNum(@PathVariable String accountNum)
	{
		return new ResponseEntity<List<Transaction>>(transactionService.getAllTransactionsByAccountNum(accountNum),HttpStatus.OK);
	}
	
}
