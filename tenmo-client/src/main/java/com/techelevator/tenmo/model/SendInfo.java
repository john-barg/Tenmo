package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class SendInfo {

    private String recipient;
    private BigDecimal amount;

    public SendInfo(String recipient, BigDecimal amount) {
        this.recipient=recipient;
        this.amount=amount;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}
