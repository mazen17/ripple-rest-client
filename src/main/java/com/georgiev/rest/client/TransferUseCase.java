package com.georgiev.rest.client;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.georgiev.web.controller.TransferForm;
import com.georgiev.web.controller.TransferInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TransferUseCase {

  public String transfer(TransferForm transfer) {

    WebResource postWebResource = RestClientUtils.getWebResource();
    String input = CreateJsons.createTransferInput(transfer);
    JsonObject json = RestClientUtils.getJsonFromResponse(postWebResource, input);
    JsonObject jsonResult = json.getJsonObject("result");

    try {
      return jsonResult.getString("tx_blob");
    }
    catch (Exception e) {
      throw new RuntimeException(jsonResult.getString("error"));
    }
  }

  public TransferInfo submit(String txBlob) {

    Client client = createRestClient();
    String postUri = "https://api.altnet.rippletest.net:51234";
    WebResource postWebResource = client.resource(postUri);
    String input = CreateJsons.createSubmitInput(txBlob);
    ClientResponse response2 = postWebResource.accept("application/json").post(ClientResponse.class, input);

    String output1 = response2.getEntity(String.class);
    InputStream in = new ByteArrayInputStream(output1.getBytes());
    JsonReader jsonReader = Json.createReader(in);
    JsonObject json = jsonReader.readObject();
    jsonReader.close();

    JsonObject jsonResult = json.getJsonObject("result");
    TransferInfo ti = new TransferInfo();

    ti.setEngineResult(jsonResult.getString("engine_result"));
    ti.setEngineResultMessage(jsonResult.getString("engine_result_message"));
    ti.setStatus(jsonResult.getString("status"));

    JsonObject jsonTx = jsonResult.getJsonObject("tx_json");
    ti.setAccount(jsonTx.getString("Account"));
    try {
      ti.setAmount(jsonTx.getString("Amount"));
      ti.setCurrency("XRP");
    }
    catch (Exception e) {
      JsonObject jsonAmount = jsonTx.getJsonObject("Amount");
      ti.setAmount(jsonAmount.getString("value"));
      ti.setCurrency(jsonAmount.getString("currency"));
    }
    ti.setDestination(jsonTx.getString("Destination"));
    ti.setFee(jsonTx.getString("Fee"));
    ti.setSigningPubKey(jsonTx.getString("SigningPubKey"));
    ti.setTransactionType(jsonTx.getString("TransactionType"));

    return ti;
  }

  private static Client createRestClient() {
    return Client.create();

  }

}
