package com.techelevator.tenmo.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class Account {

    private Long id;
    private BigDecimal balance;
    private boolean activated;

    public Account() { }

    public Account(Long id, BigDecimal balance){
        this.id = id;
        this.balance= balance;
        this.activated=true;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", balance='" + balance + '\'' +
                ", activated=" + activated +
                '}';
    }
}
