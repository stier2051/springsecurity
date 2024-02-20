package mun.course.service.impl;

import mun.course.model.AccountTransactions;
import mun.course.repository.AccountTransactionsRepository;
import mun.course.service.BalanceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.shouldHaveThrown;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BalanceServiceImplTest {

    @Autowired
    private BalanceService balanceService;
    @MockBean
    private AccountTransactionsRepository accountTransactionsRepository;

    @Test
    void findByCustomerId() {
        List<AccountTransactions> mockList = Arrays.asList(
                Mockito.mock(AccountTransactions.class),
                Mockito.mock(AccountTransactions.class),
                Mockito.mock(AccountTransactions.class),
                Mockito.mock(AccountTransactions.class),
                Mockito.mock(AccountTransactions.class)
        );

        when(accountTransactionsRepository
                .findByCustomerIdOrderByTransactionDtDesc(Mockito.anyLong()))
                .thenReturn(mockList);

        var result = balanceService.findByCustomerId(Mockito.anyLong());
        System.out.println(mockList.isEmpty());
        System.out.println(mockList.size());

        assertEquals(5, result.size());
    }
}