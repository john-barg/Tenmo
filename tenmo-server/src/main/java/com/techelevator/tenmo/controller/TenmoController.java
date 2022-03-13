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


    String account;

    @RequestMapping(path = "/users")
    public List<User> listAllUsers(){
        return userDao.findAll();
    }

    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    public Account getAccountId(@Valid Principal principal) throws AccountNotFoundException {
        return accountDAO.getAccountId(principal.getName());
    }

    @RequestMapping(path = "/accounts")
    public Account getBalance(@Valid Principal principal){
        return accountDAO.getBalance(principal.getName());
    }

    @RequestMapping(path = "/transfers", method = RequestMethod.GET)
    public Transfer getTransferId(Principal principal) throws AccountNotFoundException {
        return transferDAO.getTransferId(principal.getName());
    }

    //Add a new transfer

    // Transfer Approval?



}