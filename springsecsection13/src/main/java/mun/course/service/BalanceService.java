package mun.course.service;

import mun.course.model.AccountTransactions;

import java.util.List;

public interface BalanceService {
    List<AccountTransactions> getAllTransactions(String email);
}
