package com.budgettracker.budgettrackerapi.model;

import lombok.Data;

@Data
public class Category {
    public Integer categoryId;
    public Integer userId;
    public String title;
    public String description;
    public Double totalExpenses;
}
