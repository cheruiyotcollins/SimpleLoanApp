/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collins.loan.controller;

import com.collins.loan.model.LoanModel;
import com.collins.loan.service.LoanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author KEN19283
 */
@RestController
@RequestMapping(value="/home")
public class LoanController {
    @Autowired
    LoanService loanService;
     @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("loan_list");
        List<LoanModel> loanList = loanService.getAllLoans();
        model.addObject("loanList", loanList);
        model.setViewName("loan_list");
        return model;
    }
    @RequestMapping(value = "/addLoan/", method = RequestMethod.GET)
    public LoanModel addLoan() {

        LoanModel loanModel = new LoanModel();

        return loanModel;
    }

    @RequestMapping(value = "/updateLoan/{id}", method = RequestMethod.GET)
    public ModelAndView editLoan(@PathVariable("id_number") long id) {

        ModelAndView model = new ModelAndView();

        LoanModel loanModel = loanService.getLoanById(id);
        model.addObject("loanForm", loanModel);
        model.setViewName("loan_form");

        return model;

    }

    @RequestMapping(value = "/viewLoan/{id}", method = RequestMethod.GET)
    public ModelAndView viewLoan(@PathVariable("id_number") long id) {

        ModelAndView model = new ModelAndView();
        LoanModel personDetails = loanService.getLoanById(id);
        model.addObject("personDetails", personDetails);
        model.setViewName("person_details");

        return model;

    }

    @RequestMapping(value = "/saveLoan", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("loanForm") LoanModel loanModel) {
        loanService.saveOrUpdate(loanModel);

        return new ModelAndView("redirect:/home/list");

    }

    @RequestMapping(value = "/deleteLoan/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id) {

        loanService.deleteLoan(id);

        return new ModelAndView("redirect:/home/list");

    }

}
