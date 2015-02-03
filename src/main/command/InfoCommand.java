package main.command;

import main.CashMachine;
import main.ConsoleHelper;
import main.CurrencyManipulator;
import main.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by Александр on 08.10.14.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute()
    {

        //if (item.hasMoney())
        ConsoleHelper.writeMessage(res.getString("before"));
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty())
           ConsoleHelper.writeMessage(res.getString("no.money"));
           // System.out.println("No money available.");
        for (CurrencyManipulator item : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (item.hasMoney())
                ConsoleHelper.writeMessage(res.getString("no.money"));
            else
              System.out.println(item.getCurrencyCode() + " - " + item.getTotalAmount());
        }

    }
}
