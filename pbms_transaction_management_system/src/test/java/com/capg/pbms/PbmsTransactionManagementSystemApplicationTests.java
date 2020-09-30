package com.capg.pbms;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.pbms.model.Slip;
import com.capg.pbms.service.ITransactionService;


@SpringBootTest
class PbmsTransactionManagementSystemApplicationTests {

	@Autowired
	ITransactionService transactionService;
	Slip slip,slip1,slip2;
	
	@BeforeEach
	void init()
	{
	 slip=new Slip("","8435146976700959","harish","",1500.0,"Andhra Bank", "ANDB1223345", LocalDate.now());
	 
	 
	}
	@Test
	void contextLoads() {
		Assertions.assertThrows(Exception.class, ()->
		{
			transactionService.addSlip(slip, "credit");
		}
		);
		
	}

}
