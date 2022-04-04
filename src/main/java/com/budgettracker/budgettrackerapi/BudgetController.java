package com.budgettracker.budgettrackerapi;

import com.budgettracker.budgettrackerapi.model.User;
import com.budgettracker.budgettrackerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BudgetController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> postUser(@RequestBody Map<String, Object> userMap) {
        String firstname = (String) userMap.get("firstname");
        String lastname = (String) userMap.get("lastname");
        String email = (String) userMap.get("email");
        String password = ( String) userMap.get("password");
        User user = userService.registerUser(firstname, lastname, email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "User Created successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
