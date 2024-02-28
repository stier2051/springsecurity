package mun.course.service.impl;

import mun.course.model.Customer;
import mun.course.model.Loans;
import mun.course.repository.CustomerRepository;
import mun.course.repository.LoansRepository;
import mun.course.service.LoansService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LoansServiceImplTest {

    @Autowired
    private LoansService loansService;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private LoansRepository loansRepository;

    @Test
    void getLoanDetails() {

        List<Loans> loans = Arrays.asList(
                Mockito.mock(Loans.class),
                Mockito.mock(Loans.class),
                Mockito.mock(Loans.class)
        );

        when(customerRepository.findByEmail(Mockito.anyString()))
                .thenReturn(Collections.singletonList(Mockito.mock(Customer.class)));

        when(loansRepository.findByCustomerIdOrderByStartDtDesc(Mockito.anyLong()))
                .thenReturn(loans);

        var result = loansService.getLoanDetails(Mockito.anyString());

        assertEquals(3, result.size());
    }
}