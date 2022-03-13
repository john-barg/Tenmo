package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public interface TransferDao {

//    Transfer transfer = new Transfer();

     Transfer getTransferId(String username);

    //get all transfers
    //create transfers
    //transfer status

}
