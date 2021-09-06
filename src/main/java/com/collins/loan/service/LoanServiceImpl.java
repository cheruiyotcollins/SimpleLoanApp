/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collins.loan.service;

import com.collins.loan.model.LoanModel;
import com.collins.loan.repository.LoanRepository;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KEN19283
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;
    public int loanLimit = 0;
    public double outstandingAmount = 0.00;
    public double time = 0;

    @Override
    public List<LoanModel> getAllLoans() {

        // TODO Auto-generated method stub
        return (List<LoanModel>) loanRepository.findAll();

    }

    @Override
    public LoanModel getLoanById(long id) {
        return loanRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(LoanModel loanModel) {
        if (loanLimit <= 15000) {
            long start = System.currentTimeMillis();
// some time passes
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            outstandingAmount = loanModel.getLoanamount() + (0.10 * loanModel.getLoanamount());
            loanRepository.save(loanModel);

        }
        if (loanLimit <= 25000 && loanLimit > 15000) {
            outstandingAmount = loanModel.getLoanamount() + (loanModel.getLoanamount() * 0.125 / 100);

            loanRepository.save(loanModel);

        }

    }

    @Override
    public void deleteLoan(long id) {
        loanRepository.deleteById(id);
    }

}
