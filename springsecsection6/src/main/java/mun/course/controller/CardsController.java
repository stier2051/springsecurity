package mun.course.controller;

import mun.course.model.Cards;
import mun.course.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam Long id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }
}
