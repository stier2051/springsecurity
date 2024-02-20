package mun.course.service.impl;

import extension.GlobalExtension;
import jakarta.persistence.EntityNotFoundException;
import mun.course.model.Accounts;
import mun.course.repository.AccountsRepository;
import mun.course.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
@ExtendWith({GlobalExtension.class, MockitoExtension.class})
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountsRepository accountsRepository;

    @BeforeAll
    static void init() {
        System.out.println("before all");
    }

    @BeforeEach
    void prepare() {
        System.out.println("before each");
    }

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

    @ParameterizedTest
    @MethodSource("mun.course.service.impl.AccountServiceImplTest#getArgumentsForShouldFindByCustomerId")
    void shouldFindByCustomerId(Accounts account) {

        when(accountsRepository.findByCustomerId(Mockito.anyLong())).thenReturn(Optional.ofNullable(account));
        var result = accountService.findByCustomerId(Mockito.anyLong());
        assertThat(result.equals(account)).isTrue();
    }

    static Stream<Arguments> getArgumentsForShouldFindByCustomerId() {
        Accounts account = new Accounts(
                1865764534L,
                1L,
                "Savings",
                "123 Taugul, Almaty",
                null);
        return Stream.of(Arguments.of(account));
    }
}