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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Flux<LoanModel> getAllLoans() {
        LOGGER.info("Request to get a list of all existing loans");

        return loanRepository.findAll();

    }

    public Mono<LoanModel> getLoanById(long id) {
        return loanRepository.findById(id);
    }

    public void save(LoanModel loanModel) {
        if(loanModel.getLoan_limit()<=15000){
        loanModel.setLoan_percentage(10);
        }if(loanModel.getLoan_limit()<=25000&&loanModel.getLoan_limit()>15000){
        loanModel.setLoan_percentage(12.5);
        }
        
        loanRepository.save(loanModel);
    }

    public void saveOrUpdate(long id,LoanModel loanModel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate str = LocalDate.now();
        str.format(formatter);
        Mono<LoanModel> loan =loanRepository.findById(id);
        long loanRequest = loanModel.getAmount_requested();

        if ( loanRequest<= 15000) {
            loan.map(
                    loanInstance ->{
                        loanInstance.setAmount_due(loanRequest+(int)(0.10*loanRequest));
                        loanInstance.setDate(str.toString());
                        loanInstance.setDuedate(str.plusDays(15).toString());
                        loanInstance.setStatus("SUCCESS");
                        loanInstance.setAmount_requested(loanRequest);
                        return loanInstance;
                    }
            ).flatMap(loanInstance2 -> loanRepository.save(loanInstance2));
            ;

        }
        if (loanRequest <= 25000 && loanRequest > 15000) {
            loan.map(
                    loanInstance ->{
                        loanInstance.setAmount_due(loanRequest+(int)(0.125*loanRequest));
                        loanInstance.setDate(str.toString());
                        loanInstance.setDuedate(str.plusDays(25).toString());
                        loanInstance.setStatus("SUCCESS");
                        loanInstance.setAmount_requested(loanRequest);
                        return loanInstance;
                    }
            ).flatMap(loanInstance2 -> loanRepository.save(loanInstance2));

        }

    }

    public void deleteLoan(long id) {
        loanRepository.deleteById(id);
    }

}
