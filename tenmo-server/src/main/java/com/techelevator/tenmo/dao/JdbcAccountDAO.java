package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import javax.sql.DataSource;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override  //Revise SQL statement?
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

    @Override  //Revise SQL statement?
    public Account getUserId(String username) {
        Account account = null;
        String sql = "SELECT balance FROM account WHERE user_id IN (SELECT user_id FROM tenmo_user WHERE username = ?);";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
        if (result.next()) {
            account = mapRowToAccount(result);
        }
        if (account == null) {
//            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override  //Revise SQL statement?
    public Account getBalance(String username) {
        Account account = null;
        String sql = "SELECT balance FROM account WHERE user_id IN (SELECT user_id FROM tenmo_user WHERE username = ?);";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
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

//    @Override                           //super uncertain about recalling by username ///principal.getId
//    public  returnBalance(String username) {
//        //int id = jdbcuserdao.findidbyusername(principal)
//
//        String sql = "SELECT balance FROM account WHERE user_id IN (SELECT user_id FROM tenmo_user WHERE username = ?);";
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, username );
////        if (rowSet.next()){
////            return mapRowToAccount(rowSet);
////        }
////        throw new AccountNotFoundException("Account " +  + " was not found.");
//
//        return account;  // change accordingly
//    }
}
