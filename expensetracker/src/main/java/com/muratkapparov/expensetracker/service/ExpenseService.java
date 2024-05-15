package com.muratkapparov.expensetracker.service;

import com.muratkapparov.expensetracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
}
