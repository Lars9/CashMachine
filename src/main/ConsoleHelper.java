package main;

import main.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Александр on 03.10.14.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle("main.resources.common_en");
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
       System.out.println(message);
    }
    public static String readString() throws InterruptOperationException
    {
        String  string = "";
        try
        {
            string = reader.readLine();


           if (string.equalsIgnoreCase("exit"))
           {
              //writeMessage(res.getString("the.end"));
              throw new InterruptOperationException();
           }
      //  }

        /*catch(InterruptOperationException e)
        {
            System.out.println("Interrupt");
            //CashMachine.operation = Operation.EXIT;
        }*/
        }
        catch(IOException e){ /*e.printStackTrace();*/}
        return string;

    }

    public static String askCurrencyCode() throws InterruptOperationException
    {

       // String currencyCode = null; //reader.readLine();
        /*try
        {*/
           writeMessage(res.getString("choose.currency.code"));
           String currencyCode = readString();
           while (currencyCode.length()!=3)
           //if (currencyCode.length() != 3)
           {
             // System.out.println("currencyCode is wrong");
              writeMessage(res.getString("invalid.data"));
              currencyCode = readString();//reader.readLine();
              //throw new Exception();
           }
           currencyCode = currencyCode.toUpperCase();
        /*}
        catch(IOException e)
        {

        }*/
        return currencyCode;
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException, Exception
    {

        String [] mas = null;
       /* try
        {*/

           ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
           String stroka = readString();
           mas = stroka.split(" ");
           boolean flag = true;
          // while(flag)
           //{
             // try
             // {
                 if (mas.length != 2)
                     throw new Exception();
                 if (Integer.parseInt(mas[0]) < 0 || Integer.parseInt(mas[1]) < 0)
                     throw new Exception();
                 flag = false;
             // }
             /* catch(Exception e)
              {
                 //System.out.println("Data is incorrect");
                  ConsoleHelper.writeMessage("Data is incorrect");

                 stroka = readString();//reader.readLine();
                 mas = stroka.split(" ");

              }*/
          //}
       /* }
        catch(IOException e){}*/
        return mas;


    }

    public static Operation askOperation() throws InterruptOperationException
    {

        int i =0;
       /* try
        {*/

        ConsoleHelper.writeMessage(res.getString("choose.operation"));
        boolean flag = true;
         i = Integer.parseInt(readString());

        while (flag)
        {
           try
           {
              if (i<=0 && i>4)
                 throw new IllegalArgumentException();
              flag = false;
           }
           //catch(IOException){}
           catch(IllegalArgumentException e)
           {
              // i = Integer.parseInt(reader.readLine());
               i = Integer.parseInt(readString());
           }
        }
        /*}
        catch(IOException e){}*/
        if (i == 1)
            ConsoleHelper.writeMessage(res.getString("operation.INFO"));
        else if (i == 2)
            ConsoleHelper.writeMessage(res.getString("operation.DEPOSIT"));
        else if (i == 3)
            ConsoleHelper.writeMessage(res.getString("operation.WITHDRAW"));
        else if (i == 4)
            ConsoleHelper.writeMessage(res.getString("operation.EXIT"));
        return Operation.getAllowableOperationByOrdinal(i);
    }
    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

}

