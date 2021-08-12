package com.samsonSiba.moms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsonSiba.moms.model.AccountBook;
import com.samsonSiba.moms.repository.AccountBookRepository;
import java.util.Calendar;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
@Service
public class AccountBookServiceImpl implements AccountBookService{

	@Autowired
	private AccountBookRepository repository;
	@Override
	public List<AccountBook> getAccountBook(String date, String period) {
		// period : ЁБ, ©Ы, аж
		System.out.println(date);
		System.out.println(period);
		LocalDate dateTime = null; 
		List<AccountBook> result = null;
		LocalDate start = null;
		LocalDate end   = null;
		Calendar cal = Calendar.getInstance();
		
		switch (period) {
		case "week" : 
			dateTime = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
			start = dateTime.with(dateTime.getDayOfWeek().MONDAY);
			end   = dateTime.plusWeeks(1).with(dateTime.plusWeeks(1).getDayOfWeek().SUNDAY);
			break;
		case "month" :
			dateTime = LocalDate.parse(date +"-01", DateTimeFormatter.ISO_DATE);
			start = dateTime;
			end   = start.with(TemporalAdjusters.lastDayOfMonth());
			break;
		case "year" :
			dateTime = LocalDate.parse(date + "-01-01", DateTimeFormatter.ISO_DATE);
			start = dateTime;
			end = LocalDate.parse(date.substring(0,4)+"-12-31");
			break;
	}
		result = repository.findByExpenditureDateBetween(start, end);

		return result;
	}


}
