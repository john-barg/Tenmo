package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.security.auth.login.AccountNotFoundException;
import javax.sql.DataSource;

public class jdbcTransferDao implements TransferDao {

    private JdbcTemplate jdbcTemplate;

    public jdbcTransferDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override //update SQL
    public Transfer getTransferId(String username)  {

        Transfer transfer = null;

        String sql = "SELECT transfer_id" +
                "FROM transfer" +
                "JOIN transfer_status ON transfer_status.transfer_status_id = transfer.transfer_status_id\n" +
                "WHERE username='?';";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);

        try {
            result.next();
            transfer = mapRowToTransfer(result);
        }
        catch(Exception ex) {
//            throw new AccountNotFoundException();
        }

        return transfer;

    }
    private Transfer mapRowToTransfer(SqlRowSet rs){
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getLong("transferId"));
        transfer.setBalanceOfTransfer(rs.getBigDecimal("balanceOfTransfer"));

        return transfer;


    }

}
