package com.georgiev.rest.client;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClientUtils {

  public static WebResource getWebResource() {
    Client client = Client.create();
    String postUri = "https://api.altnet.rippletest.net:51234";
    return client.resource(postUri);
  }

  public static JsonObject getJsonFromResponse(WebResource postWebResource, String input) {
    ClientResponse response2 = postWebResource.accept("application/json").post(ClientResponse.class, input);
    String output1 = response2.getEntity(String.class);
    InputStream in = new ByteArrayInputStream(output1.getBytes());
    JsonReader jsonReader = Json.createReader(in);
    JsonObject json = jsonReader.readObject();
    jsonReader.close();

    return json;
  }
}
