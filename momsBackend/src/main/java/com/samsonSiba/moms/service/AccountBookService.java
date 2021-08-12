package com.samsonSiba.moms.service;

import java.util.Date;
import java.util.List;

import com.samsonSiba.moms.model.AccountBook;

public interface AccountBookService {
	
	List<AccountBook> getAccountBook(String date, String period);
	
}
