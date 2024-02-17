package mun.course.service;

import mun.course.model.Accounts;

public interface AccountService {
    Accounts findByCustomerId(Long id);
}
