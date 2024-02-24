package mun.course.service.impl;

import mun.course.model.AccountTransactions;
import mun.course.model.Customer;
import mun.course.repository.AccountTransactionsRepository;
import mun.course.repository.CustomerRepository;
import mun.course.service.BalanceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BalanceServiceImplTest {

    @Autowired
    private BalanceService balanceService;

    @MockBean
    private AccountTransactionsRepository accountTransactionsRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void shouldGetAllTransactions() {

        when(customerRepository.findByEmail(Mockito.anyString()))
                .thenReturn(Collections.singletonList(Mockito.mock(Customer.class)));

        List<AccountTransactions> transactions = Arrays.asList(
                Mockito.mock(AccountTransactions.class),
                Mockito.mock(AccountTransactions.class),
                Mockito.mock(AccountTransactions.class)
        );

        when(accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(Mockito.anyLong()))
                .thenReturn(transactions);

        assertEquals(3, transactions.size());
    }
}