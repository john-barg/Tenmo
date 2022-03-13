package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import javax.sql.DataSource;
import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public  Account getAccountId(String username) throws AccountNotFoundException {
        Account account = null;
        String sql = "SELECT  account_id" +
                "FROM account" +
                "JOIN tenmo_user ON tenmo_user.user_id = account.user_id" +
                "WHERE username='?');";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
        if (result.next()) {
            account = mapRowToAccount(result);
        }
        if(account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override
    public Account getUserId(String username) {
        Account account = null;
        String sql = "SELECT user_id" +
        "FROM tenmo_user" +
        "WHERE username = '?'";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
        if (result.next()) {
            account = mapRowToAccount(result);
        }
        if (account == null) {
//            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override
    public Account getBalance(String username) {
        Account account = null;
        String sql = "SELECT balance" +
                "FROM account" +
                "JOIN tenmo_user ON tenmo_user.user_id=account.user_id" +
                "WHERE username = '?'";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
        if (result.next()) {
            account = mapRowToAccount(result);
        }
        if (account == null) {
//            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override               //update SQL and adjust outputs
    public Account withdrawal(BigDecimal withdrawal){
        Account account = null;
        String sql = "";    //update
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, );
        if (result.next()) {
            account = mapRowToAccount(result);
        }
        if (account == null) {
//            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override               //Update SQL and adjust outputs
    public Account deposit(BigDecimal deposit){
        Account account = null;
        String sql = "";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,);
        if (result.next()) {
            account = mapRowToAccount(result);
        }
        if (account == null) {
//            throw new AccountNotFoundException();
        }
        return account;
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccountId(rs.getLong("account_id"));
        account.setUserId(rs.getInt("user_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        account.setActivated(true);
        return account;
    }

//----------------------


}
