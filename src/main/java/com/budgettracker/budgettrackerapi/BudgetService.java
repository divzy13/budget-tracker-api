package com.budgettracker.budgettrackerapi;

import com.budgettracker.budgettrackerapi.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    public BudgetRepository repository;

    public List<Transactions> getAllBudget() {
        return repository.findAll();
    }
}
