package com.budgettracker.budgettrackerapi.services;

import com.budgettracker.budgettrackerapi.exceptions.EtAuthException;
import com.budgettracker.budgettrackerapi.model.User;
import com.budgettracker.budgettrackerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);
        if(pattern.matcher(email).matches()) {
            throw new EtAuthException("Invalid email format");
        }
        Integer count = userRepository.getCountByEmail(email);
        if (count>0) {
            throw new EtAuthException("Email id already exist");
        }
        Integer id = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(id);
    }
}
