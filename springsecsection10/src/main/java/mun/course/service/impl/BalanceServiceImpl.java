package mun.course.service.impl;

import lombok.extern.slf4j.Slf4j;
import mun.course.model.AccountTransactions;
import mun.course.repository.AccountTransactionsRepository;
import mun.course.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;
    @Override
    public List<AccountTransactions> findByCustomerId(Long id) {
        List<AccountTransactions> accountTransactions =
                accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null) {
            log.info("endpoint myBalance");
            return accountTransactions;
        } else {
            return  null;
        }
    }
}
