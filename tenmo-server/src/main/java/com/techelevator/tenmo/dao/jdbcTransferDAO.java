package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
    public Transfer fundsTransfer(Transfer transfer, Principal principal){
        //SQL ---Look up accountId for sender and
        String sqlSender = "SELECT account_id FROM account\n" +
                "JOIN transfer ON transfer.account_from = account.account_id\n" +
                "WHERE transfer_id = '?'\n";
        //SQL --- receiver
        String sqlReceiver = "SELECT account_id FROM account\n" +
                "JOIN transfer ON transfer.account_to = account.account_id\n" +
                "WHERE transfer_id = '?'\n";

        //SQL --- use that and insert into transfer table
        String sql = "INSERT INTO transfer ( transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount decimal)\n" +
                "VALUES( '?','?','?','?','?','?' )\n";

        //SQL --- update balance for sender
        //SQL --- update balance for receiver
        return transfer;
    }

    public List<Transfer> getListOfTransfers(String username){
        List<Transfer> transferList =new ArrayList<>();
        String sql = "SELECT *FROM <transfer_id>\n";                    //Pretty Sure this  is javaSQL spanglish
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
        while (result.next()) {
            Transfer transfer = mapRowToTransfer(result);
            transferList.add(transfer);
        }
//        if (transfer == null) {
//            throw new AccountNotFoundException();
//       }
        return transferList;
    }



    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getLong("transferId"));
        transfer.setBalanceOfTransfer(rs.getBigDecimal("balanceOfTransfer"));

        return transfer;
    }


}