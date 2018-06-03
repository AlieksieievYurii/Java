package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoneyBack
{
    private int[] groszy = {1,2,5,10,20,50,100,200,500,1000,2000,5000,10000,50000};

    public ArrayList<String> countBackMoney(double price, double money)
    {
       ArrayList<Integer> resualtsGroszej = new ArrayList<>();

        int res = (int) Math.round((money - price)*100);

        while(res != 0)
        {
            for(int i = groszy.length-1; i>=0; i--)
            {
                if(groszy[i] <= res)
                {
                    res -= groszy[i];
                    resualtsGroszej.add(groszy[i]);
                    if(groszy[i] <= res) i++;
                }
            }
        }

        return bild(countMoney(resualtsGroszej));
    }

    private String convertToZloty(int groszy)
    {
        if(groszy > 100)
        {
            return groszy/100 + "   Zl   ";
        }else return groszy + "   Gr    ";
    }

    private Map<Integer, Integer> countMoney(ArrayList<Integer> resalts)
    {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (Integer resalt : resalts)
        {
            if (myMap.containsKey(resalt))
            {
                myMap.put(resalt, myMap.get(resalt) + 1);
            } else {
                myMap.put(resalt, 1);
            }
        }
        return myMap;
    }

    private ArrayList<String> bild(Map<Integer,Integer> myMap)
    {
        ArrayList<String> array = new ArrayList<>();

        for(int key : myMap.keySet())
        {
            array.add(convertToZloty(key).concat(Integer.toString(myMap.get(key))));
        }
        return array;
    }

}
