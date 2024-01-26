package mun.course.repository;

import mun.course.model.Cards;
import mun.course.model.Loans;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardsRepository extends CrudRepository<Cards, Long> {

    List<Cards> findByCustomerId(Long customerId);

}
