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


    @Override                           //super uncertain about recalling by username
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


}
