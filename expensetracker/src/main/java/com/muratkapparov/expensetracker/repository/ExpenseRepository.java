package com.muratkapparov.expensetracker.repository;

import com.muratkapparov.expensetracker.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    // Select * from tbl_expenses where category=?
    Page<Expense> findByUserIdAndCategory(Long id, String category, Pageable pageable);
    Optional<Expense> findByUserIdAndId(Long id, Long expenseId);

    Page<Expense> findByUserIdAndNameContaining(Long id ,String keyword, Pageable pageable);

    Page<Expense> findByUserIdAndDateBetween(Long id ,Date startDate, Date endDate, Pageable pageable);

    Page<Expense> findByUserId(Long userId,Pageable pageable);

}
