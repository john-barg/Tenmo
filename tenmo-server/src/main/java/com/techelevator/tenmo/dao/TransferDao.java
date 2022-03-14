package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface TransferDao {

//    Transfer transfer = new Transfer();

//     Transfer getTransferId(String username);

//     Transfer getTransferStatus(String username);

     Transfer fundsTransfer(Transfer transfer, Principal principal);

     List<Transfer> getListOfTransfers(String username);

     Transfer getTransferDetails(String username);

     //get all transfers
     //create transfers


}
