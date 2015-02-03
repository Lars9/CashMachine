package main.command;

import main.Operation;
import main.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Александр on 08.10.14.
 */
public class CommandExecutor
{
    static Map<Operation, Command> commands = new HashMap<Operation,Command>();

    private CommandExecutor(){}

    static
    {

        commands.put(Operation.LOGIN, new LoginCommand());
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.DEPOSIT, new  DepositCommand());
        commands.put(Operation.WITHDRAW, new WithdrawCommand());
        commands.put(Operation.EXIT, new ExitCommand());

    }
    public static final void execute(Operation operation) throws InterruptOperationException
    {


        for (Map.Entry<Operation, Command> item : commands.entrySet())
        {

            if(operation.equals(item.getKey()))
            {

                item.getValue().execute();
            }
        }

    }
}
