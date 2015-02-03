package main;

import main.command.CommandExecutor;
import main.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Александр on 03.10.14.
 */
public class CashMachine
{
 // public static Operation operation;'
    public static final String RESOURCE_PATH = "main.resources.";
    public static void main(String[] args) //throws IOException
    {

        Locale.setDefault(Locale.ENGLISH);
        try
        {

           Operation operation = Operation.LOGIN;
           CommandExecutor.execute(operation);
           do
           {
              operation = ConsoleHelper.askOperation();
             // System.out.println(operation);

              CommandExecutor.execute(operation);
           }while(!operation.equals(Operation.EXIT));
        }
        catch(InterruptOperationException e)
        {
            //ConsoleHelper.writeMessage("Goodbye");
            ConsoleHelper.printExitMessage();
        }

        //ConsoleHelper.askOperation();

      /*  switch (operation)
        {


            case DEPOSIT:
            {

                String currencyCode = ConsoleHelper.askCurrencyCode();
                String values [] = ConsoleHelper.getValidTwoDigits(currencyCode);
                int nominal = Integer.parseInt(values[0]);
                int count = Integer.parseInt(values[1]);
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(nominal, count);
                System.out.println(CurrencyManipulatorFactory.list.get(0).getTotalAmount());

            }break;


        }*/

        //System.out.println(operation.equals(Operation.DEPOSIT));



    }
}
