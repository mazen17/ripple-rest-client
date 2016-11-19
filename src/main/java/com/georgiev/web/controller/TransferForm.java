package com.georgiev.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransferForm {
  private String accountSource;
  private String accountDestination;
  private String amount;
  private String currency;
  private final AccountsProvider accountsProvider;

  public TransferForm() {
    accountsProvider = new AccountsProvider();
  }

  public List<String> getAccountNrs() {
    return new ArrayList<String>(accountsProvider.getAccountNrs());

  }

  public String getAccountSource() {
    return accountSource;
  }

  public void setAccountSource(String accountSource) {
    this.accountSource = accountSource;
  }

  public String getSecretKey() {
    return accountsProvider.getSecretKeyForAccountId(accountSource);
  }

  public String getAccountDestination() {
    return accountDestination;
  }

  public void setAccountDestination(String accountDestination) {
    this.accountDestination = accountDestination;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getValueDrops() {
    BigDecimal multiplier = BigDecimal.valueOf(1000000);
    return multiplier.multiply(new BigDecimal(amount)).toString();
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

}
