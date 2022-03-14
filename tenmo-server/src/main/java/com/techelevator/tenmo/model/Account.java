package com.techelevator.tenmo.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class Account {

    private Long accountId;
    private int userId;
    private BigDecimal balance;
    private boolean activated;

    public Account() { }

    public Account(Long id, BigDecimal balance){
        this.accountId = accountId;
        this.userId=userId;
        this.balance= balance;
        this.activated=true;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user id=" + userId +
                ", account id="+ accountId +
                ", balance='" + balance + '\'' +
                ", activated=" + activated +
                '}';
    }



}
