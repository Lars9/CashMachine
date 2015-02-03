package main.command;

import main.exception.InterruptOperationException;

/**
 * Created by Александр on 08.10.14.
 */
interface Command
{
    public void execute() throws InterruptOperationException;
}
