package mun.course.service.impl;

import mun.course.model.Accounts;
import mun.course.model.Customer;
import mun.course.repository.AccountsRepository;
import mun.course.repository.CustomerRepository;
import mun.course.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Collections;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountsRepository accountsRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void getAccountDetails() {

        Optional<Accounts> account = Optional.of(
                new Accounts(
                        1865764534L,
                        1L,
                        "Savings",
                        "123 Taugul, Almaty",
                        null));

        when(customerRepository.findByEmail(Mockito.anyString()))
                .thenReturn(Collections.singletonList(Mockito.mock(Customer.class)));

        when(accountsRepository.findByCustomerId(Mockito.anyLong())).thenReturn(account.get());

        var result = accountService.getAccountDetails(Mockito.anyString());
        assertThat(result.equals(account.get())).isTrue();
    }
}