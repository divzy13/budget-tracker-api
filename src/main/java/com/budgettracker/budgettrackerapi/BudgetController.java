package com.budgettracker.budgettrackerapi;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class BudgetController {

    @PostMapping("/user")
    public String postUser(@RequestBody Map<String, Object> userMap) {
        String firstname = (String) userMap.get("firstname");
        String lastname = (String) userMap.get("lastname");
        String email = (String) userMap.get("email");
        return firstname + " , " + lastname + " , " + email;
    }

}
