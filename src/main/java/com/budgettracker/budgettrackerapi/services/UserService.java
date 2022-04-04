package com.budgettracker.budgettrackerapi.services;

import com.budgettracker.budgettrackerapi.exceptions.EtAuthException;
import com.budgettracker.budgettrackerapi.model.User;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
