package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class TenmoController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(path = "/users")
    public List<User> listAllUsers(){
        return userDao.findAll();
    }

    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    public Account findingAccount( Principal principal) {
        return AccountDAO.account;
    }

    @RequestMapping(path = "/transfers")
    public Transfer findingTransfer(Principal principal) {
        return TransferDao.transfer;
    }

//RETURN ACCOUNT BALANCE
//url : /accounts
//Method : GET.principal
//DESCRIPTION: this method returns account balance
//Status Code: 200-OK
//TRANSFER FUNDS
//url : /transfer
//method : POST
//desc. : Establishes transfer amount, apply the transfer to the relative amount's
//status code: 200 -ok, insufficient funds?
//VIEW TRANSFER
//url: /transfers/{id}
//method : GET
//desc : recalls transfer amounts, retrieve further details
//status code: OK

}// create account object

//        int userId = userDao.findIdByUsername(principal.getName());
//take id and pass it to new DAO that retrieves account information for user, creating/accessing the returning account
