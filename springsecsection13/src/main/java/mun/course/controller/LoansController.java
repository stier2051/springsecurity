package mun.course.controller;

import mun.course.model.Customer;
import mun.course.model.Loans;
import mun.course.repository.CustomerRepository;
import mun.course.repository.LoansRepository;
import mun.course.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansService loansService;
    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        return loansService.getLoanDetails(email);
    }
}
