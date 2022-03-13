package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private Long transferId;
    private BigDecimal balanceOfTransfer;
    private String transferStatus;
    private String transferType;
    private Long transferToId;
    private Long transferFromId;
    private String transferToUsername;
    private String transferFromUsername;



    public Transfer () { }

    public Transfer(Long transferId, BigDecimal balanceOfTransfer){
        this.transferId = transferId;
        this.balanceOfTransfer = balanceOfTransfer;
    }

    public String getTransferToUsername() {
        return transferToUsername;
    }

    public void setTransferToUsername(String transferToUsername) {
        this.transferToUsername = transferToUsername;
    }

    public String getTransferFromUsername() {
        return transferFromUsername;
    }

    public void setTransferFromUsername(String transferFromUsername) {
        this.transferFromUsername = transferFromUsername;
    }

    public Long getTransferFromId() {
        return transferFromId;
    }

    public void setTransferFromId(Long transferFromId) {
        this.transferFromId = transferFromId;
    }

    public Long getTransferToId() {
        return transferToId;
    }

    public void setTransferToId(Long transferToId) {
        this.transferToId = transferToId;
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

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transfer id=" + transferId +
                ", balanceOfTransfer='" + balanceOfTransfer + '\'' +
                '}';
    }
}
