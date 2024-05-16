package com.muratkapparov.expensetracker.entity;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.Date;
@Data
public class ExpenseErrorException {
    private Integer statusCode;
    private String message;
    private Date timestamp;

}
