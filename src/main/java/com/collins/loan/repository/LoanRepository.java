/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collins.loan.repository;

import com.collins.loan.model.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 *
 * @author KEN19283
 */
public interface LoanRepository extends ReactiveMongoRepository<LoanModel, Long > {
    
}
