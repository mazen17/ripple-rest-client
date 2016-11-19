package com.georgiev.web.controller;

import java.util.ArrayList;
import java.util.List;

public class AccountForm {
  private String accountNr;
  private String balance;
  private final AccountsProvider accountsProvider;

  public AccountForm() {
    accountsProvider = new AccountsProvider();
  }

  public List<String> getAccountNrs() {
    return new ArrayList<String>(accountsProvider.getAccountNrs());
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

  public String getAccountNr() {
    return accountNr;
  }

  public void setAccountNr(String accountNr) {
    this.accountNr = accountNr;
  }

}
