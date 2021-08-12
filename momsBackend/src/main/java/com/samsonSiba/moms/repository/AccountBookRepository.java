package com.samsonSiba.moms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.samsonSiba.moms.model.AccountBook;

import java.util.List;
//import java.util.Date;
import java.time.LocalDate;
@Repository
public interface AccountBookRepository extends JpaRepository<AccountBook, Integer>{

	public List<AccountBook> findAll();
	public List<AccountBook> findByExpenditureDateBetween(LocalDate start, LocalDate end);		
	public AccountBook save(AccountBook record);
	//public List<AccountBook> saveAll(List<AccountBook> records);
}
