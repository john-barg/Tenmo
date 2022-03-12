package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class RequestInfo {

    private String recipientOfRequest;
    private BigDecimal amount;

    public RequestInfo(String recipientOfRequest, BigDecimal amount) {

        this.recipientOfRequest=recipientOfRequest;
        this.amount=amount;
    }

    public String getRecipientOfRequest() {
        return recipientOfRequest;
    }

    public void setRecipientOfRequest(String recipientOfRequest) {
        this.recipientOfRequest = recipientOfRequest;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
