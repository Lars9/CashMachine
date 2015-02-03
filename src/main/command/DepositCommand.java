package main.command;

import main.CashMachine;
import main.ConsoleHelper;
import main.CurrencyManipulatorFactory;
import main.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Александр on 08.10.14.
 */
 public class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException
    {

        ConsoleHelper.writeMessage(res.getString("before"));
        String  currencyCode = ConsoleHelper.askCurrencyCode();
        String values[] = null;

       // try
       // {

           boolean flag = true;
           while (flag)
           {
              try
              {

                 values  = ConsoleHelper.getValidTwoDigits(currencyCode);
                 flag = false;
              }
              catch(Exception e)
              {
                  ConsoleHelper.writeMessage(res.getString("invalid.data"));
              }

           }

           int nominal = Integer.parseInt(values[0]);
           int count = Integer.parseInt(values[1]);
           CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
           CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(nominal, count);
           ConsoleHelper.writeMessage(String.format(res.getString("success.format"),CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).getTotalAmount(), currencyCode));

          // System.out.println(CurrencyManipulatorFactory.list.get(0).getTotalAmount());
        //}
        //catch(Exception e)
      //  {
       //     ConsoleHelper.writeMessage("invalid.data");
           // values = ConsoleHelper.getValidTwoDigits(currencyCode);

       // }


      //  catch(InterruptOperationException e){}

    }
}
