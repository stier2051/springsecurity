package mun.course.controller;

import mun.course.model.Accounts;
import mun.course.repository.AccountsRepository;
import mun.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam Long id) {
        return accountService.findByCustomerId(id);
    }
}
