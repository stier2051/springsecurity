package mun.course.service.impl;

import mun.course.model.Cards;
import mun.course.model.Customer;
import mun.course.repository.CardsRepository;
import mun.course.repository.CustomerRepository;
import mun.course.service.CardsService;
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
class CardsServiceImplTest {

    @Autowired
    private CardsService cardsService;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private CardsRepository cardsRepository;

    @Test
    void shouldGetCardsDetails() {

        List<Cards> cards = Arrays.asList(
                Mockito.mock(Cards.class),
                Mockito.mock(Cards.class),
                Mockito.mock(Cards.class)
        );

        when(customerRepository.findByEmail(Mockito.anyString()))
                .thenReturn(Collections.singletonList(Mockito.mock(Customer.class)));

        when(cardsRepository.findByCustomerId(Mockito.anyLong())).thenReturn(cards);

        var result = cardsService.getCardsDetails(Mockito.anyString());
        assertEquals(3, result.size());
    }
}