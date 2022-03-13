package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import javax.sql.DataSource;

@Component
public class jdbcTransferDao implements TransferDao {

    private JdbcTemplate jdbcTemplate;

    public jdbcTransferDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Get Transfer History
    //Send payment
    //Request payment

    //Create Transfer
    public Transfer fundsTransfer(Transfer transfer){
        //SQL ---Look up accountId for sender and
        //SQL --- receiver

        //SQL --- use that and insert into transfer table

        //SQL --- update balance for sender
        //SQL --- update balance for receiver
        return transfer;
    }





    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getLong("transferId"));
        transfer.setBalanceOfTransfer(rs.getBigDecimal("balanceOfTransfer"));

        return transfer;
    }


}