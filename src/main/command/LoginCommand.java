package main.command;

import main.CashMachine;
import main.ConsoleHelper;
import main.exception.InterruptOperationException;

import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by Александр on 10.10.14.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");


    @Override
    public void execute() throws InterruptOperationException
    {

        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        String cardNumber = "";
        String pin = "";
        boolean flag = true;
        //System.out.println(validCreditCard.getString("123456789012"));
       // System.out.println(validCreditCard.keySet());
        while(flag)
        {


           //System.out.println("Enter card number(12 digits) and your pin(4 digits):");

           cardNumber = ConsoleHelper.readString();
            pin = ConsoleHelper.readString();
           char mas1[] = cardNumber.toCharArray();
           char mas2[] = pin.toCharArray();
           boolean f1 = true;
           boolean f2 = true;
           if(cardNumber.length() == 12)
           {

              for (int i = 0; i < mas1.length; i++)
              {
                  if(!Character.isDigit(mas1[i]))
                  {
                     f1 = false;
                    // System.out.println("Card Number must consist of digits");
                     ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                     break;
                  }
              }
           }
           else
           {
               //System.out.println("Card number consist of 12 digits");
               ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
               f1 = false;
           }
           if (pin.length() == 4)
           {
              for (int i = 0; i< mas2.length; i++)
              {
                  if(!Character.isDigit(mas2[i]))
                  {
                     f2 = false;
                      ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                     break;
                  }
              }
           }
           else
           {
               //System.out.println("Pin consist of 4 digits");
               ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
               f2 = false;
           }

           Set<String> numbers = new HashSet<String>(validCreditCards.keySet());
           if (validCreditCards.keySet().contains(cardNumber)/*&& validCreditCard.getString(cardNumber) !=null*/)
           {
             //System.out.println(validCreditCards.getString(cardNumber));
             if (validCreditCards.getString(cardNumber).equals(pin))
             {

                if (f1 && f2)
                  flag = false;
             }
             else
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));


           }
           else
               ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
        }
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));

    }
}
