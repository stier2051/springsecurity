package mun.course.controller;

import mun.course.model.AccountTransactions;
import mun.course.model.Customer;
import mun.course.repository.AccountTransactionsRepository;
import mun.course.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<AccountTransactions> accountTransactions =
                    accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
            if (accountTransactions != null) {
                return accountTransactions;
            }
        }
        return null;
    }
}
