package com.muratkapparov.expensetracker.service;

import com.muratkapparov.expensetracker.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable pageable);
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);
    Expense updateExpenseDetails(Long expenseId , Expense expense);
}
