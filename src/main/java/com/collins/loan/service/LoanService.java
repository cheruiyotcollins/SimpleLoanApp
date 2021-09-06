/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collins.loan.service;

import com.collins.loan.model.LoanModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author KEN19283
 */
@Service
public interface LoanService {
	 public List<LoanModel> getAllLoans();
	 
	 public  LoanModel getLoanById(long id);
	 
	 public void saveOrUpdate(LoanModel loanModel);
	 
	 public void deleteLoan(long id);
	 
	 

}
