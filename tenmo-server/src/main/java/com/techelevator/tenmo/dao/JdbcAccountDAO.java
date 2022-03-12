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

    @Override
    public  Account returnAccount(String username) throws AccountNotFoundException {

        Account account = null;

        String sql = "SELECT balance FROM account WHERE user_id IN (SELECT user_id FROM tenmo_user WHERE username = ?);";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);

        if (result.next()) {
            account = mapRowToAccount(result);
        }
        if(account == null) {
            throw new AccountNotFoundException();
        }
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



    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setId(rs.getLong("account_id"));
        account.setId(rs.getLong("user_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        account.setActivated(true);
        return account;
    }

}
