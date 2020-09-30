package com.capg.pbms.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.Exception.InsufficientBalanceException;
import com.capg.pbms.Exception.InvalidAccountNumberException;
import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.Slip;
import com.capg.pbms.model.Transaction;
import com.capg.pbms.repository.IChequeRepository;
import com.capg.pbms.repository.ISlipRepository;
import com.capg.pbms.repository.ITransacionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	ITransacionRepository transactionRepository;
	
	@Autowired
	IChequeRepository chequeRepository;
	
	@Autowired
	ISlipRepository slipRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Random random;
	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		return null;
	}

	
	@Override
	public Slip addSlip(Slip slip, String transType) throws RestClientException, URISyntaxException {
		AccountManagement account=restTemplate.getForObject("http://localhost:8200/customer/getaccount/"+slip.getAccountNum(), AccountManagement.class);
		System.out.println(transType);
		if(transType.equals("credit"))
		{
			Double balance=account.getAccountBalance()+slip.getAmount();
		    account.setAccountBalance(balance);	
		    account.setLastUpdated(LocalDate.now());
		    restTemplate.put(new URI("http://localhost:8200/customer/updateaccount"), account);
			
            Transaction transaction=new Transaction();
			
			transaction.setTransId(Integer.toString(random.nextInt(100000000)).substring(0,4));
			transaction.setTransAccountId(slip.getAccountNum());
			transaction.setTransType("credit");
			transaction.setTransAmount(slip.getAmount());
			transaction.setTransOption("slip");
			transaction.setTransDate(LocalDate.now());
			transaction.setTransClosingBalnace(balance);
			transaction.setTransFrom("XXXXXXXXXXXX");
			transaction.setTransTo(slip.getAccountNum());
			
			slip.setSlipId(Integer.toString(random.nextInt(1000000)).substring(0,4));
			slip.setSlipType(transType);
			
			slipRepository.save(slip);
			transactionRepository.save(transaction);
			
		}
		else if(transType.equals("debit"))
		{
			if(account.getAccountBalance()>slip.getAmount())
			{
				Double balance=account.getAccountBalance()-slip.getAmount();
			    account.setAccountBalance(balance);	
			    account.setLastUpdated(LocalDate.now());
			    restTemplate.put(new URI("http://localhost:8200/customer/updateaccount"), account);
				
	            Transaction transaction=new Transaction();
				
				transaction.setTransId(Integer.toString(random.nextInt(100000000)).substring(0,4));
				transaction.setTransAccountId(slip.getAccountNum());
				transaction.setTransType("debit");
				transaction.setTransAmount(slip.getAmount());
				transaction.setTransOption("slip");
				transaction.setTransDate(LocalDate.now());
				transaction.setTransClosingBalnace(balance);
				transaction.setTransFrom(slip.getAccountNum());
				transaction.setTransTo("XXXXXXXXXXXX");
				
				slip.setSlipId(Integer.toString(random.nextInt(1000000)).substring(0,4));
				slip.setSlipType(transType);
				
				slipRepository.save(slip);
				transactionRepository.save(transaction);
			}
			else {
				throw new InsufficientBalanceException("Insufficient Balance");
				
			}
		}
		else {
			throw new InvalidAccountNumberException("Invalid Account Number"); 
		}
		return slip;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		System.out.println("\n IN Service \n\n");
		return transactionRepository.findAll();
	}

	@Override
	public List<Transaction> getAllTransactionsByAccountNum(String accountNum) {
		return transactionRepository.findAllTrasactionsByAccountNum(accountNum);
	}

	

}
