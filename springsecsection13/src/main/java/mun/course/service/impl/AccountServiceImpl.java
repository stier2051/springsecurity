package mun.course.service.impl;

import mun.course.model.Accounts;
import mun.course.model.Customer;
import mun.course.repository.AccountsRepository;
import mun.course.repository.CustomerRepository;
import mun.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Accounts getAccountDetails(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            Accounts accounts = accountsRepository.findByCustomerId(customers.get(0).getId());
            if (accounts != null) {
                return accounts;
            }
        }
        return null;
    }
}
