package main.command;

import main.CashMachine;
import main.ConsoleHelper;
import main.CurrencyManipulator;
import main.CurrencyManipulatorFactory;
import main.exception.InterruptOperationException;
import main.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

/**
 * Created by Александр on 08.10.14.
 */

class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {

        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        boolean flag = true;
        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        String sum = ConsoleHelper.readString();
        char[] mas = sum.toCharArray();
        while(flag)
        {
           boolean f = false;
           mas = sum.toCharArray();
           for (int i = 0; i < mas.length; i++ )
           {
              if (!Character.isDigit(mas[i]))
              {
                  f = true;
                  break;
              }
           }
           if (f == true)
           {
               //System.out.println("Sum is incorrect!!! Enter sum again: ");
               ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
               sum = ConsoleHelper.readString();
           }
           else
           {
               //System.out.println("currencyManipulator: " + currencyManipulator.isAmountAvailable(Integer.parseInt(sum)));

               if (currencyManipulator.isAmountAvailable(Integer.parseInt(sum)))
               {
                   try
                   {
                      /*Map<Integer, Integer>*/ currencyManipulator.withdrawAmount(Integer.parseInt(sum));
                       //for (Map.Entry<Integer, Integer> item : currencyManipulator.withdrawAmount(Integer.parseInt(sum)).entrySet())
                         // System.out.println("\t" + item.getKey() + " - " + item.getValue());
                       flag = false;
                   }
                   catch(NotEnoughMoneyException e)
                   {
                       //System.out.println("Can't give this sum");
                       ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                       sum = ConsoleHelper.readString();
                   }
               }
               else
               {
                   //break;
                   //System.out.println("No this sum!!! Enter sum: ");
                   ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                   sum = ConsoleHelper.readString();
               }
           }
        }
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(sum), currencyCode));
        System.out.println("Transaction successfull completed");



       /* sum.contains(Character.is)
        while()
        while(flag)
        {

            currencyManipulator.isAmountAvailable(sum);
        }*/

    }
}
