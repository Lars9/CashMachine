package main.command;

import main.CashMachine;
import main.ConsoleHelper;
import main.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Александр on 08.10.14.
 */
class ExitCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");
    @Override
    public void execute() throws InterruptOperationException
    {
       // try
       // {
           ConsoleHelper.writeMessage(res.getString("exit.question.y.n")/*"Are you want to exit? <y,n>."*/);
           String answer = ConsoleHelper.readString();
           if (answer.equalsIgnoreCase(res.getString("yes")))
               ConsoleHelper.writeMessage(res.getString("thank.message"));


       /*}
        catch(InterruptOperationException e){}*/
        /*catch(IOException e)
        {

        }*/


    }
}
