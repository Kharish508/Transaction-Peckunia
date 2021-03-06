package com.capg.pbms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.pbms.model.Slip;

public interface ISlipRepository extends JpaRepository<Slip, String> {


	@Query("From Slip As slip where slip.accountNum = :accountNum")
	List<Slip> findAllSlipsByAccountNum(String accountNum);
}
