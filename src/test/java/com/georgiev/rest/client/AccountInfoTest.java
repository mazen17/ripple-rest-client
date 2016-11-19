package com.georgiev.rest.client;

import org.junit.Before;
import org.junit.Test;

import com.georgiev.web.controller.AccountsProvider;
import com.georgiev.web.controller.TransferForm;

public class AccountInfoTest {
  AccountsProvider provider;

  @Before
  public void setUp() {
    provider = new AccountsProvider();
  }

  @Test
  public void shouldGetBalance() {
    AccountInfoUseCase ai = new AccountInfoUseCase();
    ai.getAccountBalance(provider.getAccountNrs().get(1));
  }

  @Test
  public void shouldTransfer() {
    TransferForm form = new TransferForm();
    form.setAmount("10");
    form.setCurrency("XRP");
    form.setAccountSource(provider.getAccountNrs().get(1));
    form.setAccountDestination(provider.getAccountNrs().get(0));

    TransferUseCase tuc = new TransferUseCase();
    String transfer = tuc.transfer(form);
    tuc.submit(transfer);
  }
}
