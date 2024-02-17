package mun.course.service.impl;

import jakarta.persistence.EntityNotFoundException;
import mun.course.model.Accounts;
import mun.course.repository.AccountsRepository;
import mun.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountsRepository accountsRepository;
    @Override
    public Accounts findByCustomerId(Long id) {
        Optional<Accounts> accounts = accountsRepository.findByCustomerId(id);
        return accountsRepository.findByCustomerId(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("account not found, customer id = %s", id)));
    }
}
