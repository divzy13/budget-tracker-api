package com.budgettracker.budgettrackerapi;

import com.budgettracker.budgettrackerapi.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BudgetController {

    @Autowired
    public BudgetService budgetService;

    @PostMapping("/user")
    public String postUser(@RequestBody Map<String, Object> userMap) {
        String firstname = (String) userMap.get("firstname");
        String lastname = (String) userMap.get("lastname");
        String email = (String) userMap.get("email");
        return firstname + " , " + lastname + " , " + email;
    }

//    @GetMapping("/budget")
//    public List<Transactions> getAllBudget() {
//        return budgetService.getAllBudget();
//    }

}
