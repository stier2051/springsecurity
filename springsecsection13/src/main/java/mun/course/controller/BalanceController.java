package mun.course.controller;

import mun.course.model.AccountTransactions;
import mun.course.model.Customer;
import mun.course.repository.AccountTransactionsRepository;
import mun.course.repository.CustomerRepository;
import mun.course.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        return balanceService.getAllTransactions(email);
    }
}
