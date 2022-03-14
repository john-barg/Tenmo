package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public interface AccountDao {

    Account account = new Account();

    Account getAccountId(String username) throws AccountNotFoundException;

    Account getUserId(String username);

    Account getBalance(String username);

    Account withdrawal(BigDecimal withdrawalAmount, Account account);

    Account deposit(BigDecimal depositAmount, Account account);


//needs more logic methods, determining the availability of funds

}
