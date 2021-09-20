/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collins.loan.service;

import com.collins.loan.model.LoanModel;
import com.collins.loan.repository.LoanRepository;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author KEN19283
 */
@Service
public class LoanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    LoanRepository loanRepository;

    @Async
    public CompletableFuture<List<LoanModel>> getAllLoans() {
        LOGGER.info("Request to get a list of all existing loans");

        final List<LoanModel> loans = loanRepository.findAll();
        return CompletableFuture.completedFuture(loans);

    }

    public LoanModel getLoanById(long id) {
        return loanRepository.findById(id).get();
    }

    public void saveOrUpdate(LoanModel loanModel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate str = LocalDate.now();
        str.format(formatter);

        long loanLimit = loanModel.getAmount_requested();

        if (loanLimit <= 15000) {
            loanModel.setAmount_due(loanModel.getAmount_requested() + (int) (0.10 * loanModel.getAmount_requested()));
            loanModel.setDate(str.toString());
            loanModel.setDuedate(str.plusDays(15).toString());
            loanRepository.save(loanModel);

        }
        if (loanLimit <= 25000 && loanLimit > 15000) {
            loanModel.setAmount_due(loanModel.getAmount_requested() + (int) (0.125 * loanModel.getAmount_requested()));
            loanModel.setDate(str.toString());
            loanModel.setDuedate(str.plusDays(25).toString());
            loanRepository.save(loanModel);

        }

    }

    public void deleteLoan(long id) {
        loanRepository.deleteById(id);
    }

}
