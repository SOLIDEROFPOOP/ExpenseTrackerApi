package com.muratkapparov.expensetracker.controller;

import com.muratkapparov.expensetracker.entity.Expense;
import com.muratkapparov.expensetracker.service.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseServiceImpl expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }
    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id){
        return expenseService.getExpenseById(id);
    }
    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam("id") Long id){
        return "Deleting the expense object by its id:" + id;
    }
}
