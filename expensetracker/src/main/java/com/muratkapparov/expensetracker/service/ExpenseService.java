package com.muratkapparov.expensetracker.service;

import com.muratkapparov.expensetracker.entity.Expense;
import com.muratkapparov.expensetracker.entity.User;
import com.muratkapparov.expensetracker.entity.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable pageable);
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);
    Expense updateExpenseDetails(Long expenseId , Expense expense);
    List<Expense> readByCategory(String category, Pageable page);

    List<Expense> readByExpenseName(String key , Pageable pageable);

    List<Expense> readByDate(Date startDate, Date endDate, Pageable pageable);


}
