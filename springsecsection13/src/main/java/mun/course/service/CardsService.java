package mun.course.service;

import mun.course.model.Cards;

import java.util.List;

public interface CardsService {
    List<Cards> getCardsDetails(String email);
}
