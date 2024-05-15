package com.muratkapparov.expensetracker.service;

import com.muratkapparov.expensetracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);
    Expense updateExpenseDetails(Long expenseId , Expense expense);
}
