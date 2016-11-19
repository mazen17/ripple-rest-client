package com.georgiev.rest.client;

import com.georgiev.web.controller.TransferForm;

public class CreateJsons {

  private static final String QUOTATION_MARK = "\"";
  private static final String END = "}]}";

  private StringBuffer sb;

  private void init() {
    sb = new StringBuffer();
  }

  public static String createAccountInfoInput(String accountNumber) {
    return new CreateJsons().createAccountInfoInputString(accountNumber);
  }

  public static String createTransferInput(TransferForm transfer) {
    return new CreateJsons().createTransferInputString(transfer);
  }

  public static String createSubmitInput(String txBlob) {
    return new CreateJsons().createSubmitInputString(txBlob);
  }

  private String createAccountInfoInputString(String accountNumber) {
    init();
    createMethod("account_info");
    createKeyValuePairStringsWithComma("account", accountNumber, true);
    createKeyValuePair("strict", "true");
    createKeyValuePairStringsWithComma("ledger_index", "validated", false);
    sb.append(END);

    return sb.toString();
  }

  private String createSubmitInputString(String txBlob) {
    init();
    createMethod("submit");
    createKeyValuePairStringsWithComma("tx_blob", txBlob, false);
    sb.append(END);

    return sb.toString();
  }

  private void createMethod(String method) {
    sb.append("{ ");
    sb.append(QUOTATION_MARK);
    sb.append("method");
    sb.append(QUOTATION_MARK);
    sb.append(": ");
    sb.append(QUOTATION_MARK);
    sb.append(method);
    sb.append(QUOTATION_MARK);
    sb.append(", \n");
    sb.append(QUOTATION_MARK);
    sb.append("params");
    sb.append(QUOTATION_MARK);
    sb.append(": [ { \n");
  }

  private void createKeyValuePairStringsWithComma(String key, String value, boolean flag) {
    sb.append(QUOTATION_MARK);
    sb.append(key);
    sb.append(QUOTATION_MARK);
    sb.append(": ");
    sb.append(QUOTATION_MARK);
    sb.append(value);
    sb.append(QUOTATION_MARK);
    if (flag) {
      sb.append(",  \n");
    }
    else {
      sb.append("  \n");
    }

  }

  private void createKeyValuePair(String key, String value) {
    sb.append(QUOTATION_MARK);
    sb.append(key);
    sb.append(QUOTATION_MARK);
    sb.append(": ");
    sb.append(value);
    sb.append(",  \n");

  }

  private String createTransferInputString(TransferForm transfer) {
    init();
    createMethod("sign");

    sb.append(QUOTATION_MARK);
    sb.append("tx_json");
    sb.append(QUOTATION_MARK);
    sb.append(": { \n");

    createKeyValuePairStringsWithComma("Account", transfer.getAccountSource(), true);
    if (transfer.getCurrency().equals("XRP")) {
      createKeyValuePair("Amount", transfer.getValueDrops());
    }
    else {
      sb.append(QUOTATION_MARK);
      sb.append("Amount");
      sb.append(QUOTATION_MARK);
      sb.append(": { \n");
      createKeyValuePairStringsWithComma("currency", transfer.getCurrency(), true);
      createKeyValuePairStringsWithComma("value", transfer.getAmount(), true);
      createKeyValuePairStringsWithComma("issuer", "rf1BiGeXwwQoi8Z2ueFYTEXSwuJYfV2Jpn", false);
      sb.append("},");
    }
    createKeyValuePairStringsWithComma("Destination", transfer.getAccountDestination(), true);
    createKeyValuePairStringsWithComma("TransactionType", "Payment", false);
    sb.append("},");
    createKeyValuePair("offline", "false");
    createKeyValuePair("fee_mult_max", "10000");
    createKeyValuePairStringsWithComma("secret", transfer.getSecretKey(), false);
    sb.append(END);

    return sb.toString();
  }
}
