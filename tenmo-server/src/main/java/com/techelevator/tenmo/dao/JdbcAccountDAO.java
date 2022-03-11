package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDAO implements AccountDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

<<<<<<< HEAD
    @Override
    public BigDecimal returnBalance() {

        BigDecimal balance = new BigDecimal();

        String sql = "SELECT balance FROM account WHERE account ILIKE ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, "2001, 2002");
        if (rowSet.next()){
            return mapRowToAccount(rowSet);
        }
        throw new AccountNotFoundException("Account " + account + " was not found.");
=======
    @Override                           //super uncertain about recalling by username
    public BigDecimal returnBalance(String username) {

        String sql = "SELECT balance FROM account WHERE user_id IN (SELECT user_id FROM tenmo_user WHERE username = ?);";
        BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, username );
//        if (rowSet.next()){
//            return mapRowToAccount(rowSet);
//        }
//        throw new AccountNotFoundException("Account " +  + " was not found.");
>>>>>>> ae3a29ee0befdbd6e0f4c9bea86708d8df7a1b3e
        return balance;
    }


    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setId(rs.getLong("account_id"));
        account.setId(rs.getLong("user_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        account.setActivated(true);
        return account;
    }

}
