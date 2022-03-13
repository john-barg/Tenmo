package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class TenmoController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AccountDao accountDAO;
    @Autowired
    private TransferDao transferDAO;

    @RequestMapping(path = "/users")
    public List<User> listAllUsers(){
        return userDao.findAll();
    }

    @RequestMapping(path = "/accounts")
    public Account getBalance(@Valid Principal principal){
        return accountDAO.getBalance(principal.getName());
    }

    @RequestMapping(path = "/transfers", method = RequestMethod.POST)
    public Transfer fundsTransfer(Transfer transfer, Principal principal){
        return transferDAO.fundsTransfer(transfer);
    }

//    @RequestMapping(path = "/transfers")                  -WRITE LISTOFTRANSFERS DAO
//    public Transfer[] getListOfTransfers(Principal principal){
//        return transferDAO.getListOfTransfers(principal.getName());
//    }

//    @RequestMapping(path = "/transfers/{id}")             - WRITE GETTRANSFERBYID DAO
//    public Transfer getTransferById(@PathVariable Long id, (Principal principal){
//        return transferDAO.getTransferById(id);
//    }

    //-exception handling
    //return codes
}