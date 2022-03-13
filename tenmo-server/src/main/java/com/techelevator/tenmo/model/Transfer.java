package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private Long transferId;
    private BigDecimal balanceOfTransfer;


    public Transfer () { }

    public Transfer(Long transferId, BigDecimal balanceOfTransfer){
        this.transferId = transferId;
        this.balanceOfTransfer = balanceOfTransfer;
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public BigDecimal getBalanceOfTransfer() {
        return balanceOfTransfer;
    }

    public void setBalanceOfTransfer(BigDecimal balanceOfTransfer) {
        this.balanceOfTransfer = balanceOfTransfer;
    }



    @Override
    public String toString() {
        return "Transfer{" +
                "transfer id=" + transferId +
                ", balanceOfTransfer='" + balanceOfTransfer + '\'' +
                '}';
    }
}
