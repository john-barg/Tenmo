package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;

public class jdbcTransferDAO implements transferdao {

    private JdbcTemplate jdbcTemplate;

    public jdbcTransferDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public BigDecimal balanceOfTransfer(String username) {

        String sql = "SELECT balance FROM transfer WHERE user_id IN (SELECT user_id FROM tenmo_user WHERE username = ?);";
        BigDecimal transfer = jdbcTemplate.queryForObject(sql, BigDecimal.class, username );
//        if (rowSet.next()){
//            return mapRowToAccount(rowSet);
//        }
//        throw new AccountNotFoundException("Account " +  + " was not found.");

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
