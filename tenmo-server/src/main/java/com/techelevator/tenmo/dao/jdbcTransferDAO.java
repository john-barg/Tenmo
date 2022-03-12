package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.security.auth.login.AccountNotFoundException;
import javax.sql.DataSource;
import java.math.BigDecimal;

public class jdbcTransferDAO implements TransferDao {

    private JdbcTemplate jdbcTemplate;

    public jdbcTransferDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Transfer returnTransfer(String username) throws AccountNotFoundException {

        Transfer transfer = null;

        String sql = "SELECT balance FROM transfer WHERE user_id IN (SELECT user_id FROM tenmo_user WHERE username = ?);";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);

        if (result.next()) {
            transfer = mapRowToTransfer(result);
        }
        if(transfer == null) {
            throw new AccountNotFoundException();
        }

        return transfer;

    }
    private Transfer mapRowToTransfer(SqlRowSet rs){
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getLong("transferId"));
        transfer.setBalanceOfTransfer(rs.getBigDecimal("balanceOfTransfer"));

        return transfer;


    }

// @Override
//    public  Account returnAccount(String username) throws AccountNotFoundException {
//
//        Account account = null;
//
//        String sql = "SELECT balance FROM account WHERE user_id IN (SELECT user_id FROM tenmo_user WHERE username = ?);";
//        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
//
//        if (result.next()) {
//            account = mapRowToAccount(result);
//        }
//        if(account == null) {
//            throw new AccountNotFoundException();
//        }
//        return account;
//    }
}
