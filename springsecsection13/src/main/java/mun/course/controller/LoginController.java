package mun.course.controller;

import lombok.extern.slf4j.Slf4j;
import mun.course.model.Customer;
import mun.course.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin (Authentication authentication) {
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        log.info("login user's authorities {}", customers.get(0).getAuthorities());
        if (!customers.isEmpty()) {
            return customers.get(0);
        } else {
            return null;
        }
    }
}
