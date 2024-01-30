package mun.course.repository;

import mun.course.model.Cards;
import mun.course.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {

    List<Cards> findByCustomerId(Long customerId);

}
