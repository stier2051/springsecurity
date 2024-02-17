package mun.course.service.impl;

import jakarta.persistence.EntityNotFoundException;
import mun.course.model.Accounts;
import mun.course.repository.AccountsRepository;
import mun.course.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountsRepository accountsRepository;

    @Test
    @DisplayName("find account by customer id")
    void findByCustomerId() {
        Optional<Accounts> account = Optional.of(
                new Accounts(
                        1865764534L,
                        1L,
                        "Savings",
                        "123 Taugul, Almaty",
                        null));

        when(accountsRepository.findByCustomerId(Mockito.anyLong())).thenReturn(account);

        var result = accountService.findByCustomerId(Mockito.anyLong());
        assertThat(result.equals(account.get())).isTrue();
    }

    @Test
    void throwExceptionByFindByCustomerId() {
        assertThrows(EntityNotFoundException.class, () -> accountService.findByCustomerId(Mockito.anyLong()));
    }
}