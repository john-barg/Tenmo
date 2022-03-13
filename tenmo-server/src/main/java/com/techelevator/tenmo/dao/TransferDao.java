package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public interface TransferDao {

//    Transfer transfer = new Transfer();

//     Transfer getTransferId(String username);
//
//     Transfer getTransferStatus(String username);

     Transfer fundsTransfer(Transfer transfer);

     //get all transfers
     //create transfers


}
