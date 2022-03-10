package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TenmoController {

    @Autowired
    private UserDao userDao;

//    @PreAuthorize("permitAll")
//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    public User getBalance(@PathVariable long id) throws UsernameNotFoundException{
//        return dao.get(id);
//    }
    @RequestMapping(path ="/tenmo")
    public String tenmoService() {
        return "Hello, I am Tenmo";
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/accounts")
    public User findingAccount( String username) {
        return userDao.findByUsername(username);
    }


//RETURN ACCOUNT BALANCE
//url : /accounts
//Method : GET.principal
//DESCRPITION: this method returns account balance
//Status Code: 200-OK
//TRANSFER FUNDS
//url : /transfer
//method : POST
//desc. : Establishes transfer amount, apply the transfer to the relative amounts
//status code: 200 -ok, insufficient funds?
//VIEW TRANSFER
//url: /transfers/{id}
//method : GET
//desc : recalls transfer amounts, retrieve further details
//status code: OK

}
