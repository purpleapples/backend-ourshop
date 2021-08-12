package com.samsonSiba.moms.controller;

import org.springframework.web.bind.annotation.RestController;

import com.samsonSiba.moms.model.AccountBook;
import com.samsonSiba.moms.repository.AccountBookRepository;
import com.samsonSiba.moms.service.AccountBookService;
import com.samsonSiba.moms.service.AccountBookServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class AccountBookController {
	
	@Autowired
	AccountBookService service;
	
	@Autowired
	private AccountBookRepository repository;
	
	@GetMapping("/get")
	@ResponseBody // just using reponsebody not query string	
	public List<AccountBook> getAccountBookRecord(@RequestParam String date, @RequestParam String week) {

		List<AccountBook> listAccountBook =  service.getAccountBook(date, week);
				//repository.findAll();

		for(AccountBook x : listAccountBook) {
			System.out.println(x);
		}
		System.out.println(listAccountBook.size());

		return listAccountBook;
	}

	@PostMapping()
	public String postAccountBookRecord(@RequestBody AccountBook records) {
		repository.save(records);
		return "post";
	}
	
}
