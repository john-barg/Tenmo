package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public interface AccountDAO {

    Account account = new Account();

    Account returnAccount(String username) throws AccountNotFoundException;
}
