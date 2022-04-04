package com.budgettracker.budgettrackerapi.model;
import lombok.Data;


@Data
public class Transactions {

    private Integer transactionId;
    private Integer categoryId;
    private Integer userId;
    private Double amount;
    private String note;
    private Long transactionDate;

}
