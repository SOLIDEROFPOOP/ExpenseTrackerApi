package com.muratkapparov.expensetracker.controller;
import com.muratkapparov.expensetracker.entity.Expense;
import com.muratkapparov.expensetracker.service.ExpenseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
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
    public Expense saveExpenseDetails(@Valid @RequestBody Expense expense){
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable() Long id){
        return expenseService.updateExpenseDetails(id,expense);
    }

    @GetMapping("/expenses/category")
    public List<Expense> getExpenseByCategory(@RequestParam String category, Pageable pageable){
        return expenseService.readByCategory(category, pageable);
    }

    @GetMapping("/expenses/name")
    public List<Expense> getAllExpenses(@RequestParam String name, Pageable pageable){
        return expenseService.readByExpenseName(name, pageable);
    }

    @GetMapping("/expenses/date")
    public List<Expense> getAllExpensesByDate(@RequestParam(required = false)Date startDate, @RequestParam(required = false) Date endDate, Pageable pageable){
        return expenseService.readByDate(startDate,endDate, pageable);
    }
}
