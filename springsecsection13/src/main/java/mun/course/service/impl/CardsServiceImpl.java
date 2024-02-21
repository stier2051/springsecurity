package mun.course.service.impl;

import mun.course.model.Cards;
import mun.course.model.Customer;
import mun.course.repository.CardsRepository;
import mun.course.repository.CustomerRepository;
import mun.course.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Cards> getCardsDetails(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Cards> cards = cardsRepository.findByCustomerId(customers.get(0).getId());
            if (cards != null) {
                return cards;
            }
        }
        return null;
    }
}
