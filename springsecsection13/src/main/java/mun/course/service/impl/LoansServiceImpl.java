package mun.course.service.impl;

import mun.course.model.Customer;
import mun.course.model.Loans;
import mun.course.repository.CustomerRepository;
import mun.course.repository.LoansRepository;
import mun.course.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoansServiceImpl implements LoansService {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Loans> getLoanDetails(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customers.get(0).getId());
            if (loans != null) {
                return loans;
            }
        }
        return null;
    }
}
