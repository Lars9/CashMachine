package main;

/**
 * Created by Александр on 03.10.14.
 */
public enum Operation
{
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT ;

    //private static ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.common_en");
    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        if (i == 0)
            throw new IllegalArgumentException();
        if (i == 1)
        {
            //ConsoleHelper.writeMessage(res.getString("operation.INFO"));
            return Operation.INFO;
        }
        else if (i == 2)
            return Operation.DEPOSIT;
        else if (i == 3)
            return Operation.WITHDRAW;
        else if (i == 4)
            return Operation.EXIT;
        else
            throw new IllegalArgumentException();
    }
}
