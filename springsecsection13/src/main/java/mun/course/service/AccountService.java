package mun.course.service;

import mun.course.model.Accounts;

public interface AccountService {
    Accounts getAccountDetails(String email);
}
