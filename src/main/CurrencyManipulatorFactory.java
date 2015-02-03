package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Александр on 07.10.14.
 */
public class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory(){}
   // public static ArrayList<CurrencyManipulator> list = new ArrayList<>();
    public static Map<String, CurrencyManipulator> manipulators = new HashMap<String, CurrencyManipulator>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        //for (CurrencyManipulator item : list)
        //int i = 0;
        for (Map.Entry<String, CurrencyManipulator> item : manipulators.entrySet())
        {
            //if (item.getValue().getCurrencyCode().equals(currencyCode))
            if (item.getKey().equals(currencyCode))
                return item.getValue();
            //i++;
        }
        CurrencyManipulator newItem =new CurrencyManipulator(currencyCode);
        //list.add(newItem);
        manipulators.put(currencyCode, newItem);
        return newItem;

    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return manipulators.values();
    }

}
