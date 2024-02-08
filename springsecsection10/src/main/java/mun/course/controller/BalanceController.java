package mun.course.controller;

import lombok.extern.slf4j.Slf4j;
import mun.course.model.AccountTransactions;
import mun.course.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;
    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam Long id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null) {
            log.info("endpoint myBalance");
            return accountTransactions;
        } else {
            return  null;
        }
    }
}
