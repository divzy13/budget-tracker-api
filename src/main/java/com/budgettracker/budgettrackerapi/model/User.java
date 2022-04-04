package com.budgettracker.budgettrackerapi.model;

import lombok.Data;

@Data
public class User {
    public Integer userId;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}
