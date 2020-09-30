package com.capg.pbms.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.client.RestClientException;

import com.capg.pbms.model.Cheque;
import com.capg.pbms.model.Slip;
import com.capg.pbms.model.Transaction;

public interface ITransactionService {

	Transaction addTransaction(Transaction transaction);
	

	
	Slip addSlip(Slip slip, String transType) throws RestClientException, URISyntaxException;
	
	
	
	List<Transaction> getAllTransactions();
	
	List<Transaction> getAllTransactionsByAccountNum(String accountNum);

	
}
