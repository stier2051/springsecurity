package mun.course.controller;

import mun.course.model.Customer;
import mun.course.model.Loans;
import mun.course.repository.CustomerRepository;
import mun.course.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam String email) {
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
