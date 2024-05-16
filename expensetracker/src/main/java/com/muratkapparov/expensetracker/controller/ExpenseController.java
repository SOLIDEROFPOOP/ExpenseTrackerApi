package com.muratkapparov.expensetracker.controller;
import com.muratkapparov.expensetracker.entity.Expense;
import com.muratkapparov.expensetracker.service.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseServiceImpl expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable pageable){
        return expenseService.getAllExpenses(pageable).toList();
    }
    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id){
        return expenseService.getExpenseById(id);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam("id") Long id){
        expenseService.deleteExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense){
        return expenseService.saveExpenseDetails(expense);
    }
    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable() Long id){
        return expenseService.updateExpenseDetails(id,expense);
    }

}
