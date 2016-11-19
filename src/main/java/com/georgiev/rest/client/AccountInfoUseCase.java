package com.georgiev.rest.client;

import javax.json.JsonObject;

import com.sun.jersey.api.client.WebResource;

public class AccountInfoUseCase {

  public String getAccountBalance(String accountNumber) {

    WebResource postWebResource = RestClientUtils.getWebResource();
    String input = CreateJsons.createAccountInfoInput(accountNumber);
    JsonObject json = RestClientUtils.getJsonFromResponse(postWebResource, input);

    return json.getJsonObject("result").getJsonObject("account_data").getString("Balance");
  }
}
