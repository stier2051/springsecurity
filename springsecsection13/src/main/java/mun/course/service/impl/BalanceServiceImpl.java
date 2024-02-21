package mun.course.service.impl;

import mun.course.model.AccountTransactions;
import mun.course.model.Customer;
import mun.course.repository.AccountTransactionsRepository;
import mun.course.repository.CustomerRepository;
import mun.course.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<AccountTransactions> getAllTransactions(String email) {
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
