package com.budgettracker.budgettrackerapi.repository;

import com.budgettracker.budgettrackerapi.exceptions.EtAuthException;
import com.budgettracker.budgettrackerapi.model.User;

public interface UserRepository {

    Integer create(String firstname, String lastname, String email, String password) throws EtAuthException;

    //findByEmailAndPassword
    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    //getCountByemail
    Integer getCountByEmail(String email) throws EtAuthException;

    //findbyId
    User findById(Integer userId) throws EtAuthException;
}
