package mun.course.repository;

import mun.course.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoansRepository extends CrudRepository<Loans, Long> {

    @PreAuthorize("hasAuthority('VIEWLOANS')")
    List<Loans> findByCustomerIdOrderByStartDtDesc(Long customerId);

}
