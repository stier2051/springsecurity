package mun.course.service;

import mun.course.model.Loans;

import java.util.List;

public interface LoansService {
    List<Loans> getLoanDetails(String email);
}
