package mun.course.controller;

import mun.course.model.Cards;
import mun.course.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        return cardsService.getCardsDetails(email);
    }
}
