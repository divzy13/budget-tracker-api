package com.budgettracker.budgettrackerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    public BudgetRepository repository;

    public List<BudgetModel> getAllBudget() {
        return repository.findAll();
    }
}
