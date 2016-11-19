package com.georgiev.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsProvider {

  private final Map<String, String> accountIdSecretKeyPair;

  public AccountsProvider() {
    accountIdSecretKeyPair = new HashMap<String, String>();
    accountIdSecretKeyPair.put("rKkTAWJ6ih6JmduYnHSoyJdtGUcT5vxqRD", "shT1KupMfKFTcTr6MadhcXFtrFRk4");
    accountIdSecretKeyPair.put("rD6BCutqcLRRFQRi56iJGmJZqpp1JGkNPu", "snJqUhX7R2xpeuvzBSW1GNqTzEjzE");
  }

  public List<String> getAccountNrs() {
    return new ArrayList<String>(accountIdSecretKeyPair.keySet());
  }

  public String getSecretKeyForAccountId(String accountId) {
    return accountIdSecretKeyPair.get(accountId);
  }

}
