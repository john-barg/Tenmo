package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public interface AccountDAO {

    Account account = new Account();

    Account getAccountId(String username) throws AccountNotFoundException;

    Account getUserId(String username);

//keep making more methods relative to the account class

}
