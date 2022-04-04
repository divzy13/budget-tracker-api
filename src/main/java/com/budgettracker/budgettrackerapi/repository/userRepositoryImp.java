package com.budgettracker.budgettrackerapi.repository;

import com.budgettracker.budgettrackerapi.exceptions.EtAuthException;
import com.budgettracker.budgettrackerapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class userRepositoryImp implements UserRepository {

    public static final String SQL_CREATE_USER = "insert into bt_user(user_id, first_name, last_name, email, password) values(NEXTVAL('bt_user_seq'), ?, ?,?, ?)";
    public static final String SQL_COUNT_BY_EMAIL = "select count(*) from bt_user where email=?";
    public static final String SQL_FIND_BY_ID = "select user_id, first_name, last_name, email, password where user_id=? ";
    public static final String SQL_FIND_BY_EMAIL = "select user_id, first_name, last_name, email, password where email=? ";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String firstname, String lastname, String email, String password) throws EtAuthException {
        try {
            KeyHolder keyholder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstname);
                ps.setString(2, lastname);
                ps.setString(3, email);
                ps.setString(4, password);
                return ps;
            }, keyholder);
            return (Integer) keyholder.getKeys().get("user_id");
        }catch (Exception e){
            throw new EtAuthException("Failed to create account");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EtAuthException {
        try {
            User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[]{email}, rowMapper);
            if(!BCrypt.checkpw(password, user.getPassword())) {
                throw new EtAuthException("Invalid password");
            }
            return user;
        }catch(Exception e) {
            throw new EtAuthException("Invalid email/password");
        }
    }

    @Override
    public Integer getCountByEmail(String email) throws EtAuthException {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[]{email}, Integer.class);
    }

    @Override
    public User findById(Integer userId) throws EtAuthException {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId}, rowMapper);
    }

    private RowMapper<User> rowMapper = ((rs, rownum) -> { return new User(rs.getInt("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("password"));
    });
}
