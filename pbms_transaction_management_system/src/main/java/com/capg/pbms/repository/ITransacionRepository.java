package com.capg.pbms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.pbms.model.Transaction;

public interface ITransacionRepository extends JpaRepository<Transaction, String> {

	@Query("From Transaction As transactions where transactions.transAccountId = :accountNum")
	List<Transaction> findAllTrasactionsByAccountNum(String accountNum);
}
