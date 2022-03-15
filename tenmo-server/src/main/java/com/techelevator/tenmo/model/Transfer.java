package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private Long transferId;

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    private BigDecimal transferAmount;  //
    private String transferStatus;
    private String transferType;

    public Long getTransferAccountFrom() {
        return transferAccountTo;
    }

    public void setTransferAccountTo(Long transferAccountTo) {
        this.transferAccountTo = transferAccountTo;
    }

    private Long transferAccountTo;

    

    public void setTransferAccountFrom(Long transferAccountFrom) {
        this.transferAccountFrom = transferAccountFrom;
    }

    private Long  transferAccountFrom;
    private String transferToUsername;
    private String transferFromUsername;



    public Transfer () { }

    public Transfer(Long transferId, BigDecimal balanceOfTransfer){
        this.transferId = transferId;

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




    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
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
                ", transferAmount='" + transferAmount + '\'' +
                '}';
    }
}
