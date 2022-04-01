package com.budgettracker.budgettrackerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BudgetController {

    @Autowired
    public BudgetService budgetService;

    @GetMapping("/budget")
    public List<BudgetModel> getAllBudget() {
        return budgetService.getAllBudget();
    }

}
