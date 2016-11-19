package com.georgiev.web.controller;

public class TransferInfo {

  private String engineResult;
  private String engineResultMessage;
  private String status;
  private String account;
  private String amount;
  private String destination;
  private String fee;
  private String signingPubKey;
  private String transactionType;
  private String currency;

  public String getEngineResult() {
    return engineResult;
  }

  public void setEngineResult(String engineResult) {
    this.engineResult = engineResult;
  }

  public String getEngineResultMessage() {
    return engineResultMessage;
  }

  public void setEngineResultMessage(String engineResultMessage) {
    this.engineResultMessage = engineResultMessage;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getFee() {
    return fee;
  }

  public void setFee(String fee) {
    this.fee = fee;
  }

  public String getSigningPubKey() {
    return signingPubKey;
  }

  public void setSigningPubKey(String signingPubKey) {
    this.signingPubKey = signingPubKey;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
