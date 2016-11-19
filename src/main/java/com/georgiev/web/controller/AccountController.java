package com.georgiev.web.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.georgiev.rest.client.AccountInfoUseCase;
import com.georgiev.rest.client.TransferUseCase;

@Controller
public class AccountController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String printWelcome(ModelMap model) {
    return "hello";

  }

  @RequestMapping(value = "/newTransfer", method = RequestMethod.GET)
  public ModelAndView newTransfer(Model model) {
    TransferForm transfer = new TransferForm();
    model.addAttribute("transfer", transfer);
    return new ModelAndView("transfer", "command", transfer);
  }

  @RequestMapping(value = "/transfer", method = RequestMethod.GET)
  public ModelAndView addEmployeeToIntoDatabase(Model model) {
    return newTransfer(model);
  }

  @RequestMapping(value = "/transfer", method = RequestMethod.POST)
  public ModelAndView addNewTransferToRippleLedger(@ModelAttribute("transfer") TransferForm transfer,
                                                   ModelMap model) {
    try {
      TransferUseCase tuc = new TransferUseCase();
      TransferInfo ti = tuc.submit(tuc.transfer(transfer));
      model.addAttribute("transferInfo", ti);
    }
    catch (Exception e) {
      model.addAttribute("error", e.getMessage());
      model.addAttribute("transfer", transfer);
      e.printStackTrace();

      return new ModelAndView("transfer", "command", transfer);
    }

    return new ModelAndView("result");
  }

  @RequestMapping(value = "/account", method = RequestMethod.GET)
  public ModelAndView account(Model model) {
    AccountForm account = new AccountForm();
    model.addAttribute("account", account);
    return new ModelAndView("account", "command", account);
  }

  @RequestMapping(value = "/account", method = RequestMethod.POST)
  public ModelAndView getAccountInfo(@ModelAttribute("account") AccountForm account, ModelMap model) {
    AccountInfoUseCase ai = new AccountInfoUseCase();
    try {
      Long accountBalanceInDrops = Long.valueOf(ai.getAccountBalance(account.getAccountNr()));
      BigDecimal accountBalanceInXrp = BigDecimal.valueOf(accountBalanceInDrops)
                                                 .divide(BigDecimal.valueOf(1000000));

      account.setBalance(getLocalizedBigDecimalValue(accountBalanceInXrp, Locale.GERMANY));
    }
    catch (Exception e) {
      model.addAttribute("error", e.getMessage());
    }
    finally {
      model.addAttribute("account", account);
    }
    return new ModelAndView("account", "command", account);
  }

  private String getLocalizedBigDecimalValue(BigDecimal input, Locale locale) {
    final NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
    numberFormat.setGroupingUsed(true);
    numberFormat.setMaximumFractionDigits(4);
    numberFormat.setMinimumFractionDigits(4);
    return numberFormat.format(input);
  }
}