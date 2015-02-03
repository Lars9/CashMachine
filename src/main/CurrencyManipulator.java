package main;

import main.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Александр on 07.10.14.
 */
public class CurrencyManipulator
{
    String currencyCode;
    Map<Integer, Integer> denomination = new TreeMap<Integer, Integer>();


    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    public void addAmount(int denomination, int count)
    {
        this.denomination.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int sum = 0;
        for (Map.Entry<Integer , Integer> item : denomination.entrySet())
        {
            sum += item.getKey() * item.getValue();
        }
        return sum;
    }
    public boolean hasMoney()
    {

        if (denomination.isEmpty())
            return true;

        if(getTotalAmount() == 0)
            return true;
        return false;
    }

    public Map<Integer, Integer> getDenomination()
    {
        return denomination;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer,Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> expected = new TreeMap<Integer,Integer>();
        try
        {
            int razn = expectedAmount;
            int sum = 0;

            ArrayList<Integer> val = new ArrayList<Integer>(denomination.keySet());
            Collections.sort(val);
            Collections.reverse(val);
            for (int i : val)
            {
               int kol = 0;
               if (razn == 0)
                  break;
               if (i <= expectedAmount )
               {
                  kol = razn / i;
                  if (kol > denomination.get(i))
                  {
                     kol = kol - (kol - denomination.get(i));
                  }
                  if (kol != 0)
                    expected.put(i, kol);
               }
               sum += kol * i;
               razn = expectedAmount - sum;
            }
            if (razn != 0)
            {
               expected.clear();
               throw new NotEnoughMoneyException();
            }
            else
            {
               for (Map.Entry<Integer, Integer> item : denomination.entrySet())
               {
                  for (Map.Entry<Integer, Integer> it : expected.entrySet())
                  {
                      if (item.getKey().equals( it.getKey()))
                      {
                        item.setValue(item.getValue() - it.getValue());
                      }
                  }
               }
               ArrayList<Integer> list = new ArrayList<Integer>(expected.keySet());
               Collections.sort(list);
               Collections.reverse(list);
               for (int item : list)
               {
                   System.out.println(item + " - " +expected.get(item));
               }
            }
        }
        catch(ConcurrentModificationException e){}
        return expected;
    }
}
