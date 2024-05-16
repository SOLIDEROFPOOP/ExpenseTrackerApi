package com.muratkapparov.expensetracker.repository;

import com.muratkapparov.expensetracker.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    // Select * from tbl_expenses where category=?
    Page<Expense> findByCategory(String category, Pageable pageable);

    Page<Expense> findByNameContaining(String keyword, Pageable pageable);

    Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable pageable);

}
